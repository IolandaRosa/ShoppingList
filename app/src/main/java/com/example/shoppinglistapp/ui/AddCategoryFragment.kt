package com.example.shoppinglistapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.viewModel.CategoryViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorListener

//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class AddCategoryFragment : Fragment() {
    /*
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
*/
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var viewCategoryName: TextInputEditText
    private lateinit var viewColorPicker: ColorPickerView
    private lateinit var viewColorChoosen: ImageView
    private lateinit var btnOk: MaterialButton
    private var category: Category = Category()

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

        val view = inflater.inflate(R.layout.fragment_add_category, container, false)

        viewCategoryName = view.findViewById(R.id.editTextCategoryName)
        viewColorPicker = view.findViewById(R.id.colorPickerView)
        viewColorChoosen = view.findViewById(R.id.imageViewColorChosen)
        btnOk = view.findViewById(R.id.material_button_save)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        viewColorPicker.setColorListener(ColorListener { color, fromUser ->
            viewColorChoosen.setColorFilter(color)
            category.color = Integer.toHexString(color)
        })

        btnOk.setOnClickListener {
            saveCategory()
        }
    }

    private fun saveCategory() {

        val name = viewCategoryName.text.toString()

        if (name.trim().isEmpty() || name.length > 15) {
            viewCategoryName.setError("Deve prencher um nome com menos de 15 carateres")
            return
        }

        category.name = name

        categoryViewModel.insert(category)

        activity?.supportFragmentManager?.popBackStack()
    }

    /*fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /* if (context is OnFragmentInteractionListener) {
             listener = context
         } else {
             throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
         }*/
    }

    override fun onDetach() {
        super.onDetach()
        //listener = null
    }

    /*interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }*/

    companion object {

        @JvmStatic
        fun newInstance(/*param1: String, param2: String*/) =
            AddCategoryFragment()/*.apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
    }
}
