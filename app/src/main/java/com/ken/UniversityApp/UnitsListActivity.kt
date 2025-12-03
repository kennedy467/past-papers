
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
import com.ken.UniversityApp.model.CourseUnit
import com.ken.UniversityApp.model.UnitData

class UnitsListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "UnitsListActivity"
    }

    private lateinit var courseId: String
    private lateinit var courseTitle: String
    private var year: Int = 1
    private var semester: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        courseId = intent.getStringExtra("COURSE_ID") ?: ""
        courseTitle = intent.getStringExtra("COURSE_TITLE") ?: ""
        year = intent.getIntExtra("YEAR", 1)
        semester = intent.getIntExtra("SEMESTER", 1)

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
            text = "$courseTitle\nYear $year - Semester $semester\n\nAvailable Units:"
            textSize = 18f
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 30)
        }
        linearLayout.addView(titleView)

        val units: List<CourseUnit> = UnitData.getUnitsByCourseYearSemester(courseId, year, semester)

        if (units.isEmpty()) {
            val emptyView = TextView(this).apply {
                text = "No units available for this semester."
                textSize = 16f
                gravity = Gravity.CENTER
                setPadding(0, 50, 0, 50)
            }
            linearLayout.addView(emptyView)
        } else {
            units.forEach { unit ->
                linearLayout.addView(createUnitCard(unit))
            }
        }

        scrollView.addView(linearLayout)
        setContentView(scrollView)
    }

    private fun createUnitCard(unit: CourseUnit): CardView {
        return CardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 20) }
            radius = 8f
            cardElevation = 4f
            setContentPadding(25, 25, 25, 25)
            setCardBackgroundColor(Color.parseColor("#F3E5F5"))

            val innerLayout = LinearLayout(this@UnitsListActivity).apply {
                orientation = LinearLayout.VERTICAL
            }

            val codeView = TextView(this@UnitsListActivity).apply {
                text = unit.code
                textSize = 16f
                setTypeface(null, android.graphics.Typeface.BOLD)
                setTextColor(Color.parseColor("#7B1FA2"))
            }

            val titleView = TextView(this@UnitsListActivity).apply {
                text = unit.name
                textSize = 14f
                setTextColor(Color.BLACK)
                setPadding(0, 5, 0, 0)
            }

            innerLayout.addView(codeView)
            innerLayout.addView(titleView)
            addView(innerLayout)

            setOnClickListener { openPaperList(unit) }
        }
    }

    private fun openPaperList(unit: CourseUnit) {
        val intent = Intent(this, PaperListActivity::class.java).apply {
            putExtra("UNIT_CODE", unit.code)
            putExtra("UNIT_NAME", unit.name)
        }
        startActivity(intent)
    }
}
