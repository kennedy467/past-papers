package com.ken.UniversityApp.model

import android.R

object CourseData {
    val allCourses = listOf(
        Course(
            id = "bsc_mcs",
            title = "BSc Mathematics & Computer Science",
            code = "BSC MCS",
            description = "Bachelor of Science in Mathematics and Computer Science",
            duration = "4 Years",
            school = "School of Mathematics, Statistics and Actuarial Sciences",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_cs",
            title = "BSc Computer Science",
            code = "BSC CS",
            description = "Bachelor of Science in Computer Science",
            duration = "4 Years",
            school = "School of Computing & Informatics",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_se",
            title = "BSc Software Engineering",
            code = "BSC SE",
            description = "Bachelor of Science in Software Engineering",
            duration = "4 Years",
            school = "School of Computing & Informatics",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_it",
            title = "BSc Information Technology",
            code = "BSC IT",
            description = "Bachelor of Science in Information Technology",
            duration = "4 Years",
            school = "School of Computing & Informatics",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_ds",
            title = "BSc Data Science",
            code = "BSC DS",
            description = "Bachelor of Science in Data Science",
            duration = "4 Years",
            school = "School of Mathematics, Statistics and Actuarial Sciences",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_ai",
            title = "BSc Artificial Intelligence",
            code = "BSC AI",
            description = "Bachelor of Science in Artificial Intelligence",
            duration = "4 Years",
            school = "School of Computing & Informatics",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_cyber",
            title = "BSc Cybersecurity",
            code = "BSC CYBER",
            description = "Bachelor of Science in Cybersecurity",
            duration = "4 Years",
            school = "School of Computing & Informatics",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_stats",
            title = "BSc Statistics",
            code = "BSC STATS",
            description = "Bachelor of Science in Statistics",
            duration = "4 Years",
            school = "School of Mathematics, Statistics and Actuarial Sciences",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_actuary",
            title = "BSc Actuarial Science",
            code = "BSC ACT",
            description = "Bachelor of Science in Actuarial Science",
            duration = "4 Years",
            school = "School of Mathematics, Statistics and Actuarial Sciences",
            iconRes = R.drawable.ic_menu_help
        ),
        Course(
            id = "bsc_math",
            title = "BSc Pure Mathematics",
            code = "BSC MATH",
            description = "Bachelor of Science in Pure Mathematics",
            duration = "4 Years",
            school = "School of Mathematics, Statistics and Actuarial Sciences",
            iconRes = R.drawable.ic_menu_help
        )
    )

    // Helper to get a course by its ID
    fun getCourseById(courseId: String): Course? {
        return allCourses.find { it.id == courseId }
    }
}
