package com.example.shoppinglistapp.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.TextView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Category

class SpinnerAdapter(
    private val context: Context,
    private val categories: MutableList<Category>
) : BaseAdapter() {

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        val view = LayoutInflater.from(context).inflate(R.layout.spinner_custom_layout, null)

        val colorCategory: FrameLayout = view.findViewById(R.id.frameLayoutCategoryColor)
        val nameCategory: TextView = view.findViewById(R.id.textViewSpinnerNameCategory)


        if (categories[position].color.trim().length > 1) {
            colorCategory.background = ColorDrawable(Color.parseColor(categories[position].color))
        }

        nameCategory.text = categories[position].name

        return view
    }

    override fun getItem(position: Int): Any = categories[position]

    override fun getItemId(position: Int): Long = categories[position].id!!

    override fun getCount(): Int = categories.size
}