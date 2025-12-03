package com.ken.UniversityApp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.ken.UniversityApp.model.UnitData

class YearSemesterActivity : AppCompatActivity() {

    private lateinit var courseId: String
    private lateinit var courseTitle: String
    private lateinit var courseTitleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_year_semester)

        // Get course data from intent
        courseId = intent.getStringExtra("COURSE_ID") ?: ""
        courseTitle = intent.getStringExtra("COURSE_TITLE") ?: ""

        // Initialize views
        courseTitleTextView = findViewById(R.id.courseTitle)

        // Set course title
        courseTitleTextView.text = courseTitle

        // Set up the year selection cards
        setupYearCards()
    }

    private fun setupYearCards() {
        // Find all card views
        val year1Card = findViewById<CardView>(R.id.year1Card)
        val year2Card = findViewById<CardView>(R.id.year2Card)
        val year3Card = findViewById<CardView>(R.id.year3Card)
        val year4Card = findViewById<CardView>(R.id.year4Card)

        // Set click listeners
        year1Card.setOnClickListener { openSemesterSelection(1) }
        year2Card.setOnClickListener { openSemesterSelection(2) }
        year3Card.setOnClickListener { openSemesterSelection(3) }
        year4Card.setOnClickListener { openSemesterSelection(4) }
    }

    private fun openSemesterSelection(year: Int) {
        val intent = Intent(this, SemesterSelectionActivity::class.java).apply {
            putExtra("COURSE_ID", courseId)
            putExtra("COURSE_TITLE", courseTitle)
            putExtra("YEAR", year)
        }
        startActivity(intent)
    }
}