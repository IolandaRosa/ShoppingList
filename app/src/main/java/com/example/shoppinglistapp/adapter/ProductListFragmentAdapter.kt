package com.example.shoppinglistapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Product
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textview.MaterialTextView

class ProductListFragmentAdapter(
    var products: MutableList<Product>,
    val listener: ProductListListener
) :
    RecyclerView.Adapter<ProductListFragmentAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_list, parent, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val p = products[position]
        holder.nameCheckboxView.text = p.name
        holder.nameCheckboxView.isChecked = p.myList
        holder.brandView.text = if (p.brand.isEmpty()) "Sem marca" else p.brand
        holder.quantityView.text = (p.quantity).toString()
        holder.nameCategoryView.text = p.category?.name
        val parseColor = Color.parseColor(p.category?.color!!)
        holder.colorCategoryView.setColorFilter(parseColor)
    }

    fun updateProducts(products: MutableList<Product>?) {

        this.products = products!!

        notifyDataSetChanged()

    }

    inner class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val nameCheckboxView = v.findViewById<MaterialCheckBox>(R.id.checkboxProductName)
        val brandView = v.findViewById<MaterialTextView>(R.id.textViewProductBrand)
        val quantityView = v.findViewById<MaterialTextView>(R.id.textViewQuantity)
        val colorCategoryView = v.findViewById<ImageView>(R.id.imageViewColorCategory)
        val nameCategoryView = v.findViewById<MaterialTextView>(R.id.textViewCategory)

        //Para o swipe
        val foregroundLayout = v.findViewById<ConstraintLayout>(R.id.foreground)
        val backgroudLayout = v.findViewById<ConstraintLayout>(R.id.background)

        init {
            nameCheckboxView.setOnCheckedChangeListener { view, isChecked ->

                val p = products[adapterPosition]

                if (isChecked) {
                    p.myList = true
                    listener.setCheckOnProduct(p)
                } else {
                    p.myList = false
                    listener.unsetCheckProduct(p)
                }
            }
        }

    }

    interface ProductListListener {
        fun setCheckOnProduct(product: Product)

        fun unsetCheckProduct(product: Product)
    }
}

