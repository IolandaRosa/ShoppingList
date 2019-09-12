package com.example.shoppinglistapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Category
import com.google.android.material.textview.MaterialTextView

class CategoryListFragmentAdapter(var categories: MutableList<Category>) :
    RecyclerView.Adapter<CategoryListFragmentAdapter.CategoryListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category_list, parent, false)

        return CategoryListViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val parseColor = Color.parseColor(categories[position].color.toString())
        holder.imageViewColor.setColorFilter(parseColor)
        holder.textViewCategoryName.text = categories[position].name
    }

    fun updateCategories(categoriesList: MutableList<Category>) {
        categories = categoriesList
        this.notifyDataSetChanged()
    }

    inner class CategoryListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageViewColor = v.findViewById<ImageView>(R.id.imageViewColorCategory)
        val textViewCategoryName = v.findViewById<MaterialTextView>(R.id.textViewCategoryName)
    }
}