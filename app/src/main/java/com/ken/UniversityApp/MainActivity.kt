package com.ken.UniversityApp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.ken.UniversityApp.model.CourseSelectionActivity
import com.ken.UniversityApp.UnitsListActivity  // Correct import

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browseCoursesCard = findViewById<CardView>(R.id.browse_courses_card)
        val allPastPapersCard = findViewById<CardView>(R.id.all_past_papers_card)

        browseCoursesCard.setOnClickListener {
            Toast.makeText(this, "Browse Courses clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CourseSelectionActivity::class.java)
            startActivity(intent)
        }

        allPastPapersCard.setOnClickListener {
            Toast.makeText(this, "All Past Papers clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, UnitsListActivity::class.java)
            startActivity(intent)
        }
    }
}
