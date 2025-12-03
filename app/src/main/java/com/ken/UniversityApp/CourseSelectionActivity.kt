package com.ken.UniversityApp.model

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ken.UniversityApp.CourseAdapter
import com.ken.UniversityApp.YearSemesterActivity
import com.ken.UniversityApp.R

class CourseSelectionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchEditText: EditText
    private lateinit var adapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_selection)

        recyclerView = findViewById(R.id.coursesRecyclerView)
        searchEditText = findViewById(R.id.searchEditText)

        val courses = CourseData.allCourses  // your course list

        adapter = CourseAdapter(courses) { course ->
            val intent = Intent(this, YearSemesterActivity::class.java)
            intent.putExtra("COURSE_ID", course.id)
            intent.putExtra("COURSE_TITLE", course.title)
            intent.putExtra("COURSE_CODE", course.code)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }
        })
    }
}
