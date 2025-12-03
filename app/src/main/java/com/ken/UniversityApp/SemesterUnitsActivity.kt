package com.ken.UniversityApp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.ken.UniversityApp.model.UnitData

class SemesterUnitsActivity : AppCompatActivity() {

    private lateinit var courseId: String
    private lateinit var courseTitle: String
    private var year: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get data from intent
        courseId = intent.getStringExtra("COURSE_ID") ?: ""
        courseTitle = intent.getStringExtra("COURSE_TITLE") ?: "Selected Course"
        year = intent.getIntExtra("YEAR", 1)

        setupUI()
    }

    private fun setupUI() {
        val scrollView = ScrollView(this)
        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 50, 50, 50)
        }

        // Title
        val titleView = TextView(this).apply {
            text = "$courseTitle\nYear $year\n\nSelect Semester:"
            textSize = 20f
            setTypeface(null, Typeface.BOLD)
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 30)
        }
        linearLayout.addView(titleView)

        // Get unit counts from UnitData
        val sem1Count = UnitData.getUnitsByCourseYearSemester(courseId, year, 1).size
        val sem2Count = UnitData.getUnitsByCourseYearSemester(courseId, year, 2).size

        // Semester 1 card
        linearLayout.addView(createSemesterCard("Semester 1", "$sem1Count Units", 1))

        // Semester 2 card
        linearLayout.addView(createSemesterCard("Semester 2", "$sem2Count Units", 2))

        scrollView.addView(linearLayout)
        setContentView(scrollView)
    }

    private fun createSemesterCard(title: String, subtitle: String, semester: Int): CardView {
        return CardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 20) }
            radius = 12f
            cardElevation = 8f
            setContentPadding(30, 30, 30, 30)
            setCardBackgroundColor(Color.parseColor("#E3F2FD"))

            val innerLayout = LinearLayout(this@SemesterUnitsActivity).apply {
                orientation = LinearLayout.VERTICAL
            }

            val titleView = TextView(this@SemesterUnitsActivity).apply {
                text = title
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setTextColor(Color.BLACK)
            }

            val subtitleView = TextView(this@SemesterUnitsActivity).apply {
                text = subtitle
                textSize = 14f
                setTextColor(Color.DKGRAY)
                setPadding(0, 10, 0, 0)
            }

            innerLayout.addView(titleView)
            innerLayout.addView(subtitleView)
            addView(innerLayout)

            setOnClickListener { openUnitsList(semester) }
        }
    }

    private fun openUnitsList(semester: Int) {
        val intent = Intent(this, UnitsListActivity::class.java).apply {
            putExtra("COURSE_ID", courseId)
            putExtra("COURSE_TITLE", courseTitle)
            putExtra("YEAR", year)
            putExtra("SEMESTER", semester)
        }
        startActivity(intent)
    }
}
