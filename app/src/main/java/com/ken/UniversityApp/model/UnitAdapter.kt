package com.ken.UniversityApp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ken.UniversityApp.R  // Add this import for R
import com.ken.UniversityApp.model.CourseUnit  // Add this import

class UnitAdapter(
    private val units: List<CourseUnit>,
    private val onItemClick: (CourseUnit) -> Unit
) : RecyclerView.Adapter<UnitAdapter.UnitViewHolder>() {

    class UnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitCode: TextView = itemView.findViewById(R.id.unitCode)
        val unitName: TextView = itemView.findViewById(R.id.unitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_unit, parent, false)
        return UnitViewHolder(view)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val unit = units[position]
        holder.unitCode.text = unit.code
        holder.unitName.text = unit.name

        holder.itemView.setOnClickListener {
            onItemClick(unit)
        }
    }

    override fun getItemCount(): Int = units.size
}