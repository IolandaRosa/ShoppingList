package com.example.shoppinglistapp.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.adapter.ProductListFragmentAdapter
import com.example.shoppinglistapp.model.Product
import kotlinx.android.synthetic.main.fragment_product_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class ProductListFragment : Fragment() {

    private lateinit var productRecyclerView:RecyclerView

    //private var param1: String? = null
    //private var param2: String? = null
    //private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
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

    private fun setupProductList(){
        productRecyclerView.setHasFixedSize(true)
        productRecyclerView.layoutManager = LinearLayoutManager(activity)
        val productListAdapter = ProductListFragmentAdapter(mutableListOf(Product("feijao"),Product("arroz")))
        productRecyclerView.adapter=productListAdapter

    }

    /*interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }*/

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

