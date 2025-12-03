package com.ken.UniversityApp

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class GitHubPaperViewerActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var imageView: ImageView
    private lateinit var errorTextView: TextView
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_paper_viewer)

        // Try to find WebView first, if not found, show error
        webView = findViewById(R.id.webView) ?: run {
            // If webView is not found in layout, show error and return
            setContentView(TextView(this).apply {
                text = "Layout configuration error: WebView not found"
            })
            return
        }

        imageView = findViewById(R.id.imageView)
        errorTextView = findViewById(R.id.errorTextView)
        titleTextView = findViewById(R.id.titleTextView)

        val url = intent.getStringExtra("PAPER_URL")
        val title = intent.getStringExtra("PAPER_TITLE")

        if (url.isNullOrBlank()) {
            showError("No URL provided")
            return
        }

        titleTextView.text = title ?: "Paper"
        setupWebView()

        when {
            url.endsWith(".pdf") -> showPdfWithWebView(url)
            url.endsWith(".jpg", ignoreCase = true)
                    || url.endsWith(".jpeg", ignoreCase = true)
                    || url.endsWith(".png", ignoreCase = true)
                    || url.endsWith(".gif", ignoreCase = true) -> showImage(url)
            else -> {
                // For other file types or web pages, use WebView
                showWebContent(url)
            }
        }
    }

    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                showError("Failed to load: $description")
            }
        }
    }

    private fun showPdfWithWebView(pdfUrl: String) {
        imageView.visibility = View.GONE
        webView.visibility = View.VISIBLE
        errorTextView.visibility = View.GONE

        // Use Google Docs viewer for PDFs
        val googleDocsUrl = "https://docs.google.com/gview?embedded=true&url=$pdfUrl"
        webView.loadUrl(googleDocsUrl)
    }

    private fun showWebContent(url: String) {
        imageView.visibility = View.GONE
        webView.visibility = View.VISIBLE
        errorTextView.visibility = View.GONE
        webView.loadUrl(url)
    }

    private fun showImage(url: String) {
        webView.visibility = View.GONE
        imageView.visibility = View.VISIBLE
        errorTextView.visibility = View.GONE

        Glide.with(this)
            .load(url)
            .into(imageView)
    }

    private fun showError(message: String) {
        webView.visibility = View.GONE
        imageView.visibility = View.GONE
        errorTextView.visibility = View.VISIBLE
        errorTextView.text = message
    }

    override fun onBackPressed() {
        if (webView.visibility == View.VISIBLE && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}