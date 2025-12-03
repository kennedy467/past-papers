package com.ken.UniversityApp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ken.UniversityApp.model.UnitData
import com.ken.UniversityApp.model.CourseUnit

@Composable
fun SemesterScreen(
    courseId: String,
    year: Int,
    onUnitSelected: (CourseUnit) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Year $year",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Select Semester:",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Semester 1 Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable {
                    // Handle semester 1 click
                    val semester1Units = UnitData.getUnitsByCourseYearSemester(courseId, year, 1)
                },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Semester 1",
                    style = MaterialTheme.typography.headlineSmall
                )
                val semester1Units = UnitData.getUnitsByCourseYearSemester(courseId, year, 1)
                Text(
                    text = "${semester1Units.size} Units Available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Semester 2 Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable {
                    // Handle semester 2 click
                    val semester2Units = UnitData.getUnitsByCourseYearSemester(courseId, year, 2)
                },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Semester 2",
                    style = MaterialTheme.typography.headlineSmall
                )
                val semester2Units = UnitData.getUnitsByCourseYearSemester(courseId, year, 2)
                Text(
                    text = "${semester2Units.size} Units Available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}