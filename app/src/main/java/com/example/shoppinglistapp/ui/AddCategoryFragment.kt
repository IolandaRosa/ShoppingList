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

class AddCategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var viewCategoryName: TextInputEditText
    private lateinit var viewColorPicker: ColorPickerView
    private lateinit var viewColorChoosen: ImageView
    private lateinit var btnOk: MaterialButton
    private var category: Category = Category()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

            val hexColor = String.format("#%06X", (0xFFFFFF and color))

            category.color = hexColor
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


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        @JvmStatic
        fun newInstance() = AddCategoryFragment()
    }
}
