package com.ken.UniversityApp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.ken.UniversityApp.model.Paper
import com.ken.UniversityApp.model.PaperRepository

class PaperListActivity : AppCompatActivity() {

    private lateinit var unitCode: String
    private lateinit var unitName: String
    private lateinit var repository: PaperRepository

    companion object {
        private const val TAG = "PaperListDebug"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "=== PAPER LIST ACTIVITY STARTED ===")

        repository = PaperRepository(this)

        // Get unit data from intent
        unitCode = intent.getStringExtra("UNIT_CODE") ?: ""
        unitName = intent.getStringExtra("UNIT_NAME") ?: ""

        Log.d(TAG, "Unit Code: $unitCode")
        Log.d(TAG, "Unit Name: $unitName")

        // Check assets
        checkAssets()

        setupUI()
    }

    private fun checkAssets() {
        Log.d(TAG, "=== CHECKING ASSETS FOLDER ===")
        try {
            val assetFiles = assets.list("")
            Log.d(TAG, "Files in assets folder: ${assetFiles?.joinToString(", ") ?: "EMPTY"}")
        } catch (e: Exception) {
            Log.e(TAG, "Error listing assets: ${e.message}")
        }
    }

    private fun setupUI() {
        val scrollView = ScrollView(this)
        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 50, 50, 50)
        }

        // Title
        val titleView = TextView(this).apply {
            text = "$unitCode - $unitName\n\nAvailable Past Papers:"
            textSize = 18f
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 30)
        }
        linearLayout.addView(titleView)

        // Get papers for this unit
        val papers: List<Paper> = repository.getPapersByUnit(unitCode)

        Log.d(TAG, "Found ${papers.size} papers for unit $unitCode")
        papers.forEachIndexed { index, paper ->
            Log.d(TAG, "Paper $index: ${paper.paperTitle}")
            Log.d(TAG, "  File names: ${paper.fileNames}")
        }

        if (papers.isEmpty()) {
            val emptyView = TextView(this).apply {
                text = "No past papers available for this unit."
                textSize = 16f
                gravity = Gravity.CENTER
                setPadding(0, 50, 0, 50)
            }
            linearLayout.addView(emptyView)
        } else {
            papers.forEach { paper ->
                linearLayout.addView(createPaperCard(paper))
            }
        }

        scrollView.addView(linearLayout)
        setContentView(scrollView)
    }

    private fun createPaperCard(paper: Paper): CardView {
        return CardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 20) }
            radius = 8f
            cardElevation = 4f
            setContentPadding(25, 25, 25, 25)
            setCardBackgroundColor(Color.parseColor("#E3F2FD"))

            val innerLayout = LinearLayout(this@PaperListActivity).apply {
                orientation = LinearLayout.VERTICAL
            }

            val titleView = TextView(this@PaperListActivity).apply {
                text = paper.getDisplayTitle()
                textSize = 16f
                setTypeface(null, android.graphics.Typeface.BOLD)
                setTextColor(Color.parseColor("#1976D2"))
            }

            val detailsView = TextView(this@PaperListActivity).apply {
                val pageCount = if (paper.fileNames.isNotEmpty()) paper.fileNames.size else 1
                text = "Year: ${paper.year} | Type: ${paper.paperType} | Size: ${paper.fileSize} | Pages: $pageCount" +
                        if (paper.isRemoteImage()) " ☁️" else " 📱"
                textSize = 14f
                setTextColor(Color.BLACK)
                setPadding(0, 5, 0, 0)
            }

            innerLayout.addView(titleView)
            innerLayout.addView(detailsView)
            addView(innerLayout)

            setOnClickListener {
                Log.d(TAG, "Clicked on paper: ${paper.paperTitle}")
                openPaperViewer(paper)
            }
        }
    }

    private fun openPaperViewer(paper: Paper) {
        Log.d(TAG, "=== OPENING PAPER VIEWER ===")
        Log.d(TAG, "Paper: ${paper.paperTitle}")
        Log.d(TAG, "File names to pass: ${paper.fileNames}")

        val intent = Intent(this@PaperListActivity, PaperDetailActivity::class.java).apply {
            // Pass all necessary data
            putExtra("PAPER_TITLE", paper.paperTitle)
            putExtra("UNIT_CODE", paper.unitCode)
            putExtra("UNIT_NAME", paper.unitName)
            putExtra("YEAR", paper.year)
            putExtra("PAPER_TYPE", paper.paperType)
            putExtra("FILE_SIZE", paper.fileSize)
            putExtra("SEMESTER", paper.semester)
            putExtra("REMOTE_URL", paper.remoteUrl)
            // Pass the file names list
            putStringArrayListExtra("FILE_NAMES", ArrayList(paper.fileNames))
        }
        startActivity(intent)
    }
}