package com.ken.UniversityApp.model

data class Course(
    val id: String,
    val title: String,
    val code: String,
    val description: String,
    val duration: String,
    val school: String,
    val iconRes: Int
)
