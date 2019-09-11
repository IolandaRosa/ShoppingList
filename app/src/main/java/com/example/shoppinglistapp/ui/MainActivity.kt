package com.example.shoppinglistapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.viewModel.ProductViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var productListFragment: ProductListFragment
    private lateinit var addCategoryFragment: AddCategoryFragment

    companion object {
        private const val TAG_FRAGMENT_PRODUCT_LIST = "ProductListFragment"
        private const val TAG_FRAGMENT_CATEGORY_ADD = "AddCategoryFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        setupProductListFragment()

        fab.setOnClickListener{
            //abrir fragmento para criar o produto

            Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupProductListFragment() {
        productListFragment = ProductListFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, productListFragment, TAG_FRAGMENT_PRODUCT_LIST)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add_category->{

                setupAddCategoryFragment()
                return true
            }
            R.id.action_list_category->{
                return super.onOptionsItemSelected(item)
            }
            R.id.action_home->{
                return super.onOptionsItemSelected(item)
            }
            R.id.action_my_list->{
                return super.onOptionsItemSelected(item)
            }
            R.id.action_add_search->{
                return super.onOptionsItemSelected(item)
            }
            else ->return super.onOptionsItemSelected(item)

        }
    }

    private fun setupAddCategoryFragment(){
        addCategoryFragment = AddCategoryFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,addCategoryFragment, TAG_FRAGMENT_CATEGORY_ADD)
            .addToBackStack(TAG_FRAGMENT_CATEGORY_ADD)
            .commit()
    }
}
