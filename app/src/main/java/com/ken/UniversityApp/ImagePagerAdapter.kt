package com.ken.UniversityApp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import com.ken.UniversityApp.R

class ImagePagerAdapter(
    private val context: Context,
    private val imageFiles: List<String>
) : RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pager_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int = imageFiles.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val fileName = imageFiles[position]
        Glide.with(context)
            .load("file:///android_asset/$fileName")
            .into(holder.imageView)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: PhotoView = itemView.findViewById(R.id.pagerImageView)
    }
}

