package com.ken.UniversityApp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.ken.UniversityApp.model.UnitData

class SemesterSelectionActivity : AppCompatActivity() {

    private lateinit var courseId: String
    private lateinit var courseTitle: String
    private var year: Int = 1
    private lateinit var courseTitleTextView: TextView
    private lateinit var semester1UnitsCount: TextView
    private lateinit var semester2UnitsCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semester_selection)

        // Get data from intent
        courseId = intent.getStringExtra("COURSE_ID") ?: ""
        courseTitle = intent.getStringExtra("COURSE_TITLE") ?: ""
        year = intent.getIntExtra("YEAR", 1)

        // Initialize views
        courseTitleTextView = findViewById(R.id.courseTitle)
        semester1UnitsCount = findViewById(R.id.semester1UnitsCount)
        semester2UnitsCount = findViewById(R.id.semester2UnitsCount)

        // Set course title and year
        courseTitleTextView.text = "$courseTitle - Year $year"

        // Set up semester cards
        setupSemesterCards()
    }

    private fun setupSemesterCards() {
        // Calculate unit counts
        val semester1Units = UnitData.getUnitsByCourseYearSemester(courseId, year, 1).size
        val semester2Units = UnitData.getUnitsByCourseYearSemester(courseId, year, 2).size

        // Update unit counts
        semester1UnitsCount.text = "$semester1Units Units"
        semester2UnitsCount.text = "$semester2Units Units"

        // Find card views
        val semester1Card = findViewById<CardView>(R.id.semester1Card)
        val semester2Card = findViewById<CardView>(R.id.semester2Card)

        // Set click listeners
        semester1Card.setOnClickListener { openUnitsList(1) }
        semester2Card.setOnClickListener { openUnitsList(2) }
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