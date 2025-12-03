package com.ken.UniversityApp.model

import android.content.Context
import java.io.IOException

class PaperRepository(private val context: Context) {

    fun getAllPapers(): List<Paper> {
        // Use the PaperData object instead of sample data
        return PaperData.getAllPapers()
    }

    fun getPapersByUnit(unitCode: String): List<Paper> {
        // Use PaperData's function
        return PaperData.getPapersByUnitCode(unitCode)
    }

    fun getPapersByYear(year: Int): List<Paper> {
        // Use PaperData's function
        return PaperData.getPapersByYear(year)
    }

    fun getPapersBySemester(semester: String): List<Paper> {
        // Use PaperData's function
        return PaperData.getPapersBySemester(semester)
    }

    fun getPapersByType(paperType: String): List<Paper> {
        // Use PaperData's function
        return PaperData.getPapersByType(paperType)
    }

    fun searchPapers(query: String): List<Paper> {
        return getAllPapers().filter {
            it.unitCode.contains(query, ignoreCase = true) ||
                    it.unitName.contains(query, ignoreCase = true) ||
                    it.paperTitle.contains(query, ignoreCase = true) ||
                    it.semester.contains(query, ignoreCase = true) ||
                    it.unitCode.contains(query, ignoreCase = true)
        }
    }

    fun getAvailableUnits(): List<String> {
        // Use PaperData's function
        return PaperData.getAvailableUnitCodes()
    }

    fun getAvailableYears(): List<Int> {
        // Use PaperData's function
        return PaperData.getAvailableYears()
    }

    fun getAvailableSemesters(): List<String> {
        return getAllPapers().map { it.semester }.distinct().sorted()
    }

    fun getAvailablePaperTypes(): List<String> {
        return getAllPapers().map { it.paperType }.distinct().sorted()
    }

    fun paperFileExists(fileName: String): Boolean {
        return try {
            context.assets.open(fileName).close()
            true
        } catch (e: IOException) {
            false
        }
    }

    fun getPaperById(paperId: String): Paper? {
        // Use PaperData's function
        return PaperData.getPaperById(paperId)
    }

    // Additional helper functions
    fun getPapersByUnitAndYear(unitCode: String, year: Int): List<Paper> {
        return getAllPapers().filter { it.unitCode == unitCode && it.year == year }
    }

    fun getPapersBySemesterAndYear(semester: String, year: Int): List<Paper> {
        return getAllPapers().filter { it.semester == semester && it.year == year }
    }

    fun getDistinctYears(): List<Int> {
        return getAllPapers().map { it.year }.distinct().sortedDescending()
    }
}