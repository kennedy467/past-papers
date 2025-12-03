package com.ken.UniversityApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ken.UniversityApp.model.Course
import com.ken.UniversityApp.R

class CourseAdapter(
    private var courses: List<Course>,
    private val onItemClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private var filteredCourses: List<Course> = courses

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseTitle: TextView = itemView.findViewById(R.id.courseName)
        val courseCode: TextView = itemView.findViewById(R.id.courseCode)
        val courseSchool: TextView = itemView.findViewById(R.id.courseSchool)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = filteredCourses[position]

        holder.courseTitle.text = course.title
        holder.courseCode.text = course.code
        holder.courseSchool.text = course.school

        holder.itemView.setOnClickListener {
            onItemClick(course)
        }
    }

    override fun getItemCount(): Int = filteredCourses.size

    fun filter(query: String) {
        filteredCourses = if (query.isEmpty()) {
            courses
        } else {
            courses.filter {
                it.title.contains(query, true) ||
                        it.code.contains(query, true) ||
                        it.school.contains(query, true)
            }
        }
        notifyDataSetChanged()
    }
}

