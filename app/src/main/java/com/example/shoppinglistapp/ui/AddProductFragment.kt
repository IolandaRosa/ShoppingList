package com.example.shoppinglistapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.utils.SpinnerAdapter
import com.example.shoppinglistapp.viewModel.CategoryViewModel
import com.example.shoppinglistapp.viewModel.ProductViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AddProductFragment(private var product: Product, private var isAdd: Boolean) : Fragment() {

    private lateinit var viewProductName:TextInputEditText
    private lateinit var viewProductBrand:TextInputEditText
    private lateinit var spinnerCategories:Spinner
    private lateinit var btnOk:MaterialButton
    private lateinit var categoryViewModel:CategoryViewModel
    private lateinit var productViewModel: ProductViewModel
    private lateinit var categories:MutableList<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_product, container, false)

        viewProductName = view.findViewById(R.id.editTextProductName)
        viewProductBrand = view.findViewById(R.id.editTextProductBrand)
        spinnerCategories = view.findViewById(R.id.spinnerCategories)
        btnOk = view.findViewById(R.id.material_button_save_product)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupViewModel()

        populateSpinnerCategories()

        setupProduct()
    }

    /*fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
        //listener = null
    }

    private fun setupViewModel(){
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
    }

    private fun populateSpinnerCategories(){
        //Vai buscar a lista de categorias
        categoryViewModel.categoriesAll.observe(this, Observer { categoriesList ->
            categories = categoriesList
            //Vai popular o spinner com nome e cor
            //Lista de Nome
            var categoriesNames= mutableListOf<String>()
            var categoriesColors= mutableListOf<String>()

            for(c in categories){
                categoriesNames.add(c.name)
                categoriesColors.add(c.color)
            }

            val categoriesAdapter: SpinnerAdapter = SpinnerAdapter(activity?.applicationContext!!,categories)
            spinnerCategories.adapter=categoriesAdapter

            //setSpinnerListener()


        })

    }

    private fun setupProduct(){
        viewProductName.setText(product.name)
        viewProductBrand.setText(product.brand)
    }


    /*interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }*/

    companion object {
        @JvmStatic
        fun newInstance(product: Product, isAdd: Boolean) =
            AddProductFragment(product, isAdd)
    }
}
