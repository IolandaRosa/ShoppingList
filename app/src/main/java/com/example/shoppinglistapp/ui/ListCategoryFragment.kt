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
import com.example.shoppinglistapp.adapter.CategoryListFragmentAdapter
import com.example.shoppinglistapp.adapter.OnDeleteCategoryListener
import com.example.shoppinglistapp.adapter.OnEditCategoryListener
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.viewModel.CategoryViewModel

class ListCategoryFragment : Fragment(), OnDeleteCategoryListener, OnEditCategoryListener {
    private lateinit var recyclerViewCategoryList: RecyclerView
    private lateinit var categoryViewModel: CategoryViewModel
    private var categories = mutableListOf<Category>()
    private lateinit var categoriesListAdapter: CategoryListFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_category, container, false)

        recyclerViewCategoryList = view.findViewById(R.id.recyclerViewCategoriesList)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupCategoriesList()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListCategoryFragment()
    }

    private fun setupCategoriesList() {

        recyclerViewCategoryList.setHasFixedSize(true)

        recyclerViewCategoryList.layoutManager = LinearLayoutManager(activity)

        categoriesListAdapter = CategoryListFragmentAdapter(categories, this, this)

        categoryViewModel.categoriesAll.observe(this, Observer { categoriesList ->
            categories = categoriesList
            categoriesListAdapter.updateCategories(categories)
        })

        recyclerViewCategoryList.adapter = categoriesListAdapter
    }

    override fun onClickEditCategory(position: Int) {

        val editCategory = categories[position]

        fragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            AddCategoryFragment.newInstance(editCategory, false),
            MainActivity.TAG_FRAGMENT_CATEGORY_ADD
        )?.addToBackStack(MainActivity.TAG_FRAGMENT_CATEGORY_ADD)?.commit()
    }

    override fun onClickDeleteCategory(position: Int) {
        val removedCategory = categories.removeAt(position)

        categoriesListAdapter.updateCategories(categories)

        categoryViewModel.delete(removedCategory)
    }
}
