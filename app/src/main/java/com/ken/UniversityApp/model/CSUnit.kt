package com.ken.UniversityApp.model

data class CSUnit(
    val id: String,
    val title: String,
    val code: String,
    val description: String,
    val year: Int,
    val semester: Int,
    val courseId: String,
    val topics: List<String>,
    val iconRes: Int
)