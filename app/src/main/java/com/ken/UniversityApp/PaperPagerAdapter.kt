package com.ken.UniversityApp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PaperPagerAdapter(private val fileNames: List<String>) :
    RecyclerView.Adapter<PaperPagerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.pageImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_paper_page, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = fileNames.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val path = fileNames[position]
        val assetPath = if (!path.startsWith("http")) "file:///android_asset/$path" else path
        Glide.with(holder.itemView.context)
            .load(assetPath)
            .into(holder.imageView)
    }
}

