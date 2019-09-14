package com.example.shoppinglistapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.adapter.ProductListFragmentAdapter
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.utils.RecyclerItemTouchHelper
import com.example.shoppinglistapp.viewModel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : Fragment(), RecyclerItemTouchHelper.RecyclerItemTouchHelperListener,
    ProductListFragmentAdapter.ProductListListener {

    private lateinit var productRecyclerView: RecyclerView
    private lateinit var productsViewModel: ProductViewModel
    private lateinit var productsListAdapter: ProductListFragmentAdapter
    private var products = mutableListOf<Product>()
    private var init = true

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

        productsListAdapter = ProductListFragmentAdapter(products, this)

        ItemTouchHelper(RecyclerItemTouchHelper(this)).attachToRecyclerView(recyclerViewProductsList)

        productsViewModel.productsAll.observe(this, Observer { productsList ->
            products = productsList
            productsListAdapter.updateProducts(products)
        })

        productRecyclerView.adapter = productsListAdapter

    }

    override fun onSwipeDelete(position: Int) {

        val product = products[position]

        products.removeAt(position)

        productsViewModel.delete(product)
        productsListAdapter.updateProducts(products)
    }

    override fun onSwipeUpdate(position: Int) {

        val product = products[position]

        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            AddProductFragment.newInstance(product, false),
            MainActivity.TAG_FRAGMENT_PRODUCT_ADD
        )?.addToBackStack(MainActivity.TAG_FRAGMENT_PRODUCT_ADD)?.commit()
    }

    override fun setCheckOnProduct(product: Product) {
        productsViewModel.update(product)
    }

    override fun unsetCheckProduct(product: Product) {
        product.quantity = 0
        productsViewModel.update(product)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductListFragment()
    }
}

