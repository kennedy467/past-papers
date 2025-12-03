package com.ken.UniversityApp

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.ken.UniversityApp.model.PaperData
import com.ken.UniversityApp.model.Paper
import java.io.File
import java.io.FileOutputStream

class PaperViewActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var webView: WebView
    private lateinit var prevBtn: ImageButton
    private lateinit var nextBtn: ImageButton
    private lateinit var saveBtn: ImageButton
    private lateinit var shareBtn: ImageButton
    private lateinit var pageIndicator: TextView
    private lateinit var loadingLayout: View
    private lateinit var loadingText: TextView

    private var currentPages: List<String> = emptyList()
    private var isUsingPager = false
    private var currentPaper: Paper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_view)

        bindViews()
        handleIntentAndLoad()
        bindButtons()
    }

    private fun bindViews() {
        viewPager = findViewById(R.id.imageViewPager)
        webView = findViewById(R.id.pdfWebView)
        prevBtn = findViewById(R.id.prevButton)
        nextBtn = findViewById(R.id.nextButton)
        saveBtn = findViewById(R.id.saveButton)
        shareBtn = findViewById(R.id.shareButton)
        pageIndicator = findViewById(R.id.pageIndicatorText)
        loadingLayout = findViewById(R.id.loadingLayout)
        loadingText = findViewById(R.id.loadingTextView)

        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false
        settings.cacheMode = WebSettings.LOAD_NO_CACHE

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                hideLoading()
            }
        }
    }

    private fun handleIntentAndLoad() {
        val paperId = intent.getStringExtra("PAPER_ID")
        val titleTv = findViewById<TextView>(R.id.paperTitleTextView)
        val infoTv = findViewById<TextView>(R.id.paperInfoTextView)

        if (!paperId.isNullOrBlank()) {
            val paper = PaperData.getPaperById(paperId)
            if (paper != null) {
                currentPaper = paper
                titleTv.text = paper.paperTitle
                infoTv.text = "Unit: ${paper.unitCode} • Year: ${paper.year} • Type: ${paper.paperType}"

                if (paper.fileNames.isNotEmpty()) {
                    loadImagesFromAssets(paper.fileNames)
                } else if (paper.remoteUrl.isNotBlank()) {
                    loadFromUrl(paper.remoteUrl)
                } else {
                    showError("No paper pages available.")
                }
            }
        } else {
            showError("No paper source provided.")
        }
    }

    private fun loadImagesFromAssets(names: List<String>) {
        currentPages = names
        isUsingPager = true
        showLoading("Loading images...")
        webView.visibility = View.GONE
        viewPager.visibility = View.VISIBLE

        val adapter = PaperPagerAdapter(names)
        viewPager.adapter = adapter

        updatePageIndicator(0, names.size)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updatePageIndicator(position, names.size)
            }
        })
        hideLoading()
    }

    private fun loadFromUrl(url: String) {
        showLoading("Loading from URL...")
        val fixedUrl = if (url.contains("github.com") && !url.contains("raw.githubusercontent.com")) {
            url.replace("github.com", "raw.githubusercontent.com").replace("/blob/", "/")
        } else url

        if (fixedUrl.endsWith(".pdf", ignoreCase = true)) {
            webView.visibility = View.VISIBLE
            viewPager.visibility = View.GONE
            webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$fixedUrl")
            isUsingPager = false
        } else {
            loadImagesFromAssets(listOf(fixedUrl))
        }
    }

    private fun updatePageIndicator(position: Int, total: Int) {
        pageIndicator.text = "${position + 1} / $total"
        prevBtn.isEnabled = position > 0
        nextBtn.isEnabled = position < total - 1
    }

    private fun bindButtons() {
        prevBtn.setOnClickListener { if (isUsingPager && viewPager.currentItem > 0) viewPager.currentItem -= 1 }
        nextBtn.setOnClickListener { if (isUsingPager && viewPager.currentItem < (viewPager.adapter?.itemCount ?: 1) - 1) viewPager.currentItem += 1 }
        saveBtn.setOnClickListener { saveOrShareCurrent(false) }
        shareBtn.setOnClickListener { saveOrShareCurrent(true) }
    }

    private fun saveOrShareCurrent(share: Boolean) {
        val pos = viewPager.currentItem
        val filePath = currentPages.getOrNull(pos) ?: return
        val isAsset = !filePath.startsWith("/") && !filePath.startsWith("http")

        if (isAsset) {
            val assetPath = "file:///android_asset/$filePath"
            Glide.with(this).asBitmap().load(assetPath).into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    try {
                        val pictures = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                        val outFile = File(pictures, "paper_${System.currentTimeMillis()}.png")
                        FileOutputStream(outFile).use { fos -> resource.compress(Bitmap.CompressFormat.PNG, 100, fos) }
                        if (share) shareFile(outFile) else showMessage("Saved to: ${outFile.absolutePath}")
                    } catch (e: Exception) { showError("Save failed.") }
                }
                override fun onLoadCleared(placeholder: android.graphics.drawable.Drawable?) {}
            })
        } else {
            val file = if (filePath.startsWith("http")) File(cacheDir, "temp_downloaded.png") else File(filePath)
            if (share) shareFile(file) else showMessage("Saved to: ${file.absolutePath}")
        }
    }

    private fun shareFile(file: File) {
        val uri: Uri = FileProvider.getUriForFile(this, "${packageName}.fileprovider", file)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share paper"))
    }

    private fun showLoading(msg: String) { loadingText.text = msg; loadingLayout.visibility = View.VISIBLE }
    private fun hideLoading() { loadingLayout.visibility = View.GONE }
    private fun showError(msg: String) { hideLoading(); loadingText.text = msg; loadingLayout.visibility = View.VISIBLE }
    private fun showMessage(msg: String) { hideLoading(); loadingText.text = msg; loadingLayout.visibility = View.VISIBLE }
}

