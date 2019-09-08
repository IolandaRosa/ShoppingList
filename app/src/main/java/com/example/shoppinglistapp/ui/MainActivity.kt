package com.example.shoppinglistapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppinglistapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var productListFragment: ProductListFragment

    companion object {
        private const val TAG_FRAGMENT_PRODUCT_LIST = "ProductListFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        setupProductListFragment()
    }

    private fun setupProductListFragment() {
        productListFragment = ProductListFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, productListFragment, TAG_FRAGMENT_PRODUCT_LIST)
            .commit()
    }
}
