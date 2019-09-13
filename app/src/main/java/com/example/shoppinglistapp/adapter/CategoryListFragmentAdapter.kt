package com.example.shoppinglistapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Category
import com.google.android.material.textview.MaterialTextView

class CategoryListFragmentAdapter(
    var categories: MutableList<Category>,
    var deleteListener: OnDeleteCategoryListener,
    var editListener: OnEditCategoryListener
) :
    RecyclerView.Adapter<CategoryListFragmentAdapter.CategoryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category_list, parent, false)

        return CategoryListViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val parseColor = Color.parseColor(categories[position].color.plus(""))
        holder.imageViewColor.setColorFilter(parseColor)
        holder.textViewCategoryName.text = categories[position].name

        holder.imageButtonDelete.setOnClickListener {
            deleteListener.onClickDeleteCategory(position)
        }

        holder.imageButtonEdit.setOnClickListener {
            editListener.onClickEditCategory(position)
        }
    }

    fun updateCategories(categoriesList: MutableList<Category>) {
        categories = categoriesList
        this.notifyDataSetChanged()
    }

    inner class CategoryListViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imageViewColor = v.findViewById<ImageView>(R.id.imageViewColorCategory)
        val textViewCategoryName = v.findViewById<MaterialTextView>(R.id.textViewCategoryName)
        val imageButtonDelete = v.findViewById<ImageButton>(R.id.imageButtonDelete)
        val imageButtonEdit = v.findViewById<ImageButton>(R.id.imageButtonEdit)
    }
}

interface OnEditCategoryListener {
    fun onClickEditCategory(position: Int)
}

interface OnDeleteCategoryListener {
    fun onClickDeleteCategory(position: Int)
}