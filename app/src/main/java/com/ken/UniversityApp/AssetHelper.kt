package com.ken.UniversityApp.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException

object AssetHelper {

    fun loadBitmapFromAssets(context: Context, fileName: String): Bitmap? {
        return try {
            val inputStream = context.assets.open(fileName)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            bitmap
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun fileExistsInAssets(context: Context, fileName: String): Boolean {
        return try {
            context.assets.open(fileName).close()
            true
        } catch (e: IOException) {
            false
        }
    }

    fun getAssetFileList(context: Context, path: String): List<String> {
        return try {
            context.assets.list(path)?.toList() ?: emptyList()
        } catch (e: IOException) {
            emptyList()
        }
    }
}