package com.example.shoppinglistapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.adapter.ProductListFragmentAdapter
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.viewModel.ProductViewModel

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class ProductListFragment : Fragment() {

    private lateinit var productRecyclerView: RecyclerView
    private lateinit var productsViewModel: ProductViewModel
    private lateinit var productsListAdapter: ProductListFragmentAdapter
    private var products = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productsViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        productRecyclerView = view.findViewById(R.id.recyclerViewProductsList)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupProductList()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    private fun setupProductList() {
        productRecyclerView.setHasFixedSize(true)
        productRecyclerView.layoutManager = LinearLayoutManager(activity)

        productsListAdapter = ProductListFragmentAdapter(products)

        productsViewModel.productsAll.observe(this, Observer { productsList ->
            products = productsList
            productsListAdapter.updateProducts(products)
        })

        productRecyclerView.adapter = productsListAdapter

    }

    interface OnProductListFragmentListener {

        fun onClickAddProduct()
    }

    companion object {
        @JvmStatic
        fun newInstance(/*param1: String, param2: String*/) =
            ProductListFragment()/*.apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }*/
    }
}

