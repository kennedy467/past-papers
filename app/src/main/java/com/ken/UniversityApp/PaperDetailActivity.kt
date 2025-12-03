package com.ken.UniversityApp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.github.chrisbanes.photoview.PhotoView

class PaperDetailActivity : AppCompatActivity() {

    private lateinit var paperImageView: PhotoView
    private lateinit var loadingProgressBar: ProgressBar
    private lateinit var loadingTextView: TextView
    private lateinit var paperImageTitle: TextView
    private lateinit var paperImageInfo: TextView
    private lateinit var loadingLayout: View
    private lateinit var imageScrollView: View
    private lateinit var errorTextView: TextView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var navigationLayout: View

    private var currentPage = 0
    private lateinit var fileNames: List<String>
    private lateinit var paperTitle: String
    private lateinit var unitCode: String
    private var year: Int = 0
    private lateinit var paperType: String
    private lateinit var remoteUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PaperDetail", "=== onCreate STARTED ===")

        try {
            setContentView(R.layout.activity_paper_detail)
            Log.d("PaperDetail", "setContentView completed")

            initializeViews()
            loadPaperData()
            setupNavigation()
            Log.d("PaperDetail", "=== onCreate COMPLETED ===")
        } catch (e: Exception) {
            Log.e("PaperDetail", "Error in onCreate: ${e.message}", e)
            finish()
        }
    }

    private fun initializeViews() {
        Log.d("PaperDetail", "Initializing views...")
        try {
            paperImageView = findViewById(R.id.paperImageView)
            loadingProgressBar = findViewById(R.id.loadingProgressBar)
            loadingTextView = findViewById(R.id.loadingTextView)
            paperImageTitle = findViewById(R.id.paperImageTitle)
            paperImageInfo = findViewById(R.id.paperImageInfo)
            loadingLayout = findViewById(R.id.loadingLayout)
            imageScrollView = findViewById(R.id.imageScrollView)
            errorTextView = findViewById(R.id.errorTextView)
            prevButton = findViewById(R.id.prevButton)
            nextButton = findViewById(R.id.nextButton)
            navigationLayout = findViewById(R.id.navigationLayout)

            Log.d("PaperDetail", "All views initialized successfully")
        } catch (e: Exception) {
            Log.e("PaperDetail", "Error initializing views: ${e.message}", e)
            throw e
        }

        setupPhotoView()
    }

    private fun setupPhotoView() {
        Log.d("PaperDetail", "Setting up PhotoView for zooming")

        // Enable zooming
        paperImageView.setZoomable(true)

        // Set scale levels for smooth zooming
        paperImageView.setScaleLevels(1.0f, 3.0f, 8.0f)

        // Set the initial scale type
        paperImageView.scaleType = android.widget.ImageView.ScaleType.FIT_CENTER

        // Reset to initial scale
        paperImageView.setScale(1.0f, false)

        Log.d("PaperDetail", "✅ PhotoView zoom ENABLED")
    }

    private fun setupNavigation() {
        Log.d("PaperDetail", "Setting up navigation buttons")

        prevButton.setOnClickListener {
            Log.d("PaperDetail", "Previous button clicked")
            if (currentPage > 0) {
                currentPage--
                loadCurrentPage()
            }
        }

        nextButton.setOnClickListener {
            Log.d("PaperDetail", "Next button clicked")
            if (currentPage < fileNames.size - 1) {
                currentPage++
                loadCurrentPage()
            }
        }
    }

    private fun loadPaperData() {
        Log.d("PaperDetail", "Loading paper data from intent...")

        // Get paper data from intent extras
        paperTitle = intent.getStringExtra("PAPER_TITLE") ?: ""
        year = intent.getIntExtra("YEAR", 2023)
        paperType = intent.getStringExtra("PAPER_TYPE") ?: ""
        unitCode = intent.getStringExtra("UNIT_CODE") ?: ""
        remoteUrl = intent.getStringExtra("REMOTE_URL") ?: ""
        fileNames = intent.getStringArrayListExtra("FILE_NAMES") ?: emptyList()

        // DEBUG: Log the intent data
        Log.d("PaperDetail", "=== INTENT DATA ===")
        Log.d("PaperDetail", "PAPER_TITLE: '$paperTitle'")
        Log.d("PaperDetail", "YEAR: '$year'")
        Log.d("PaperDetail", "PAPER_TYPE: '$paperType'")
        Log.d("PaperDetail", "UNIT_CODE: '$unitCode'")
        Log.d("PaperDetail", "REMOTE_URL: '$remoteUrl'")
        Log.d("PaperDetail", "FILE_NAMES: $fileNames")
        Log.d("PaperDetail", "FILE_NAMES count: ${fileNames.size}")

        // Check if we have minimal required data
        if (fileNames.isEmpty() && remoteUrl.isBlank()) {
            Log.e("PaperDetail", "No file names or remote URL provided!")
            showError("No paper source available")
            return
        }

        // Update UI with paper info
        paperImageTitle.text = paperTitle
        updatePageInfo()
        Log.d("PaperDetail", "UI updated with paper info")
        Log.d("PaperDetail", "Paper has ${fileNames.size} pages")

        // Load the image
        loadCurrentPage()
    }

    private fun updatePageInfo() {
        val pageInfo = if (fileNames.size > 1) {
            "Unit: $unitCode • Year: $year • Type: $paperType • Page ${currentPage + 1}/${fileNames.size}"
        } else {
            "Unit: $unitCode • Year: $year • Type: $paperType"
        }
        paperImageInfo.text = pageInfo

        // Update navigation button states
        updateNavigationButtons()
    }

    private fun updateNavigationButtons() {
        // Show/hide navigation layout based on number of pages
        if (fileNames.size > 1) {
            navigationLayout.visibility = View.VISIBLE
            prevButton.isEnabled = currentPage > 0
            nextButton.isEnabled = currentPage < fileNames.size - 1

            Log.d("PaperDetail", "Navigation: Page ${currentPage + 1}/${fileNames.size}")
            Log.d("PaperDetail", "Prev enabled: ${prevButton.isEnabled}, Next enabled: ${nextButton.isEnabled}")
        } else {
            navigationLayout.visibility = View.GONE
        }
    }

    private fun loadCurrentPage() {
        Log.d("PaperDetail", "=== LOADING PAGE ${currentPage + 1} ===")

        // Check if we have files to load
        if (fileNames.isEmpty() && remoteUrl.isBlank()) {
            Log.e("PaperDetail", "No image sources available")
            showError("No image source available")
            return
        }

        // If remote URL exists, use it
        if (remoteUrl.isNotBlank()) {
            loadRemoteImage(remoteUrl)
            return
        }

        // Make sure currentPage is within bounds for local files
        if (currentPage >= fileNames.size) {
            currentPage = 0
        }

        val currentFileName = fileNames[currentPage]
        Log.d("PaperDetail", "Current File Name: '$currentFileName'")

        updatePageInfo()

        // Check if file exists in assets
        try {
            Log.d("PaperDetail", "Checking assets folder for: $currentFileName")
            val inputStream = assets.open(currentFileName)
            Log.d("PaperDetail", "✅ SUCCESS: Asset file '$currentFileName' opened successfully!")
            inputStream.close()
        } catch (e: Exception) {
            Log.e("PaperDetail", "❌ ERROR: Cannot open asset '$currentFileName' - ${e.message}")
            showError("Cannot find file '$currentFileName' in assets folder")
            return
        }

        val loadingText = if (fileNames.size > 1) {
            "Loading page ${currentPage + 1} of ${fileNames.size}..."
        } else {
            "Loading paper image..."
        }
        loadingTextView.text = loadingText
        Log.d("PaperDetail", "Loading text set: $loadingText")

        // Show loading and hide content
        loadingLayout.visibility = View.VISIBLE
        imageScrollView.visibility = View.GONE
        errorTextView.visibility = View.GONE

        // Load the local image
        loadLocalImage(currentFileName)
    }

    private fun loadRemoteImage(imageUrl: String) {
        Log.d("PaperDetail", "Loading remote image: $imageUrl")
        try {
            Glide.with(this)
                .load(imageUrl)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.e("PaperDetail", "❌ Glide load failed: ${e?.message}")
                        showError("Failed to download image: ${e?.message ?: "Network error"}")
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable>,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.d("PaperDetail", "✅ Glide load SUCCESSFUL!")
                        onImageLoaded()
                        return false
                    }
                })
                .into(paperImageView)

        } catch (e: Exception) {
            Log.e("PaperDetail", "❌ Exception in loadRemoteImage: ${e.message}")
            showError("Error loading remote image: ${e.message}")
        }
    }

    private fun loadLocalImage(fileName: String) {
        Log.d("PaperDetail", "Loading local image from assets: $fileName")

        // Try direct bitmap loading first (most reliable for assets)
        try {
            // Open the asset file
            val inputStream = assets.open(fileName)

            // Decode the bitmap
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = false
            options.inPreferredConfig = Bitmap.Config.RGB_565 // Use less memory

            val bitmap = BitmapFactory.decodeStream(inputStream, null, options)
            inputStream.close()

            if (bitmap != null) {
                Log.d("PaperDetail", "✅ Direct bitmap loading SUCCESSFUL! Size: ${bitmap.width}x${bitmap.height}")
                runOnUiThread {
                    paperImageView.setImageBitmap(bitmap)
                    onImageLoaded()
                }
            } else {
                Log.e("PaperDetail", "❌ Bitmap is null after decoding")
                // Fallback to Glide
                loadWithGlide(fileName)
            }

        } catch (e: Exception) {
            Log.e("PaperDetail", "❌ Exception in direct bitmap loading: ${e.message}")
            // Fallback to Glide
            loadWithGlide(fileName)
        }
    }

    private fun loadWithGlide(fileName: String) {
        Log.d("PaperDetail", "Trying Glide fallback for: $fileName")

        val assetPath = "file:///android_asset/$fileName"

        Glide.with(this)
            .load(assetPath)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("PaperDetail", "❌ Glide asset load failed: ${e?.message}")
                    showError("Failed to load image from assets using Glide")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("PaperDetail", "✅ Glide asset load SUCCESSFUL!")
                    onImageLoaded()
                    return false
                }
            })
            .into(paperImageView)
    }

    private fun onImageLoaded() {
        Log.d("PaperDetail", "✅ Image loaded successfully, updating UI...")

        runOnUiThread {
            loadingLayout.visibility = View.GONE
            imageScrollView.visibility = View.VISIBLE

            // Force a layout refresh
            paperImageView.requestLayout()
            paperImageView.invalidate()

            showZoomInstructions()
            Log.d("PaperDetail", "✅ UI updated - image should be visible now")
        }
    }

    private fun showZoomInstructions() {
        Log.d("PaperDetail", "Showing zoom instructions")

        val instructions = if (fileNames.size > 1) {
            "✓ Loaded! PINCH TO ZOOM • Double-tap to zoom/reset • Use buttons below to navigate"
        } else {
            "✓ Loaded! PINCH TO ZOOM • Double-tap to zoom/reset"
        }

        loadingTextView.text = instructions
        loadingTextView.setTextColor(resources.getColor(android.R.color.holo_green_dark, theme))
        loadingTextView.visibility = View.VISIBLE

        loadingTextView.postDelayed({
            if (fileNames.size > 1) {
                loadingTextView.text = "Page ${currentPage + 1}/${fileNames.size}"
            } else {
                loadingTextView.visibility = View.GONE
            }
        }, 3000)
    }

    private fun showError(message: String) {
        Log.e("PaperDetail", "Showing error: $message")
        runOnUiThread {
            loadingLayout.visibility = View.GONE
            imageScrollView.visibility = View.GONE
            errorTextView.text = message
            errorTextView.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        if (paperImageView.scale > 1.5f) {
            // If zoomed in, reset zoom first
            paperImageView.setScale(1.0f, true)
        } else {
            super.onBackPressed()
        }
    }
}