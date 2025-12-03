package com.ken.UniversityApp.model

import java.io.Serializable

data class Paper(
    val id: String = "",
    val paperTitle: String = "",
    val unitCode: String = "",
    val unitName: String = "",
    val year: Int = 0,
    val paperType: String = "",
    val fileNames: List<String> = emptyList(), // All pages go here
    val remoteUrl: String = "",
    val fileSize: String = "",
    val semester: String = ""
) : Serializable {

    fun getDisplayTitle(): String {
        return paperTitle
    }

    // Returns list of URLs for images (local assets or remote)
    fun getImageUrls(): List<String> {
        return if (isRemoteImage()) {
            listOf(remoteUrl)
        } else {
            fileNames.map { "file:///android_asset/$it" }
        }
    }

    // Get first image URL
    fun getFirstImageUrl(): String {
        return getImageUrls().firstOrNull() ?: ""
    }

    fun isRemoteImage(): Boolean {
        return remoteUrl.isNotBlank()
    }

    fun isLocalAsset(): Boolean {
        return remoteUrl.isBlank() && fileNames.isNotEmpty()
    }

    fun hasMultiplePages(): Boolean {
        return fileNames.size > 1
    }

    fun getPageCount(): Int {
        return fileNames.size
    }

    fun getPrimaryFileName(): String {
        return fileNames.firstOrNull() ?: ""
    }
}
