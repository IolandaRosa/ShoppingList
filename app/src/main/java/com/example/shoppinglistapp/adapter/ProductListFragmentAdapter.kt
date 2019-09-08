package com.example.shoppinglistapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Product
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class ProductListFragmentAdapter(var products: MutableList<Product>) :
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
        holder.nameCheckboxView.isChecked=p.myList
        holder.brandView.text = if (p.brand.isEmpty()) "Sem marca" else p.brand
        holder.quantityView.hint =  (p.quantity).toString()

        /*var p = Product(holder.nameCheckboxView.text.toString())

        if (holder.nameCheckboxView.isChecked) {

            p.myList = true
        }

        val brand = holder.brandView.text.toString()

        if (holder.brandView.isVisible && !brand.isEmpty()) {
            p.brand = brand
        }

        val quantityString = holder.quantityView.text.toString()

        var quantity = 0
        if(!quantityString.isEmpty()){
            quantity = Integer.parseInt(quantityString)
        }

        if (quantity > 0) {
            p.quantity = quantity
        }*/
    }

    inner class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val nameCheckboxView = v.findViewById<MaterialCheckBox>(R.id.checkboxProductName)
        val brandView = v.findViewById<MaterialTextView>(R.id.textViewProductBrand)
        val quantityView = v.findViewById<TextInputEditText>(R.id.editTextQuantity)
    }

}
