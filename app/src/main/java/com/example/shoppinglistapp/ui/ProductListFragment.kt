package com.example.shoppinglistapp.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.adapter.ProductListFragmentAdapter
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.model.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_product_list.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class ProductListFragment : Fragment() {

    private lateinit var productRecyclerView: RecyclerView
    //private var listener: OnProductListFragmentListener? = null


    //private var param1: String? = null
    //private var param2: String? = null


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

        /*fab_add_button.setOnClickListener{
            //listener?.onClickAddProduct()
            //adiciona com o view model
            Toast.makeText(context,"my toast on fragment",Toast.LENGTH_SHORT).show()
        }*/

        setupProductList()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*if (context is OnProductListFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
        //listener = null
    }

    private fun setupProductList() {
        productRecyclerView.setHasFixedSize(true)
        productRecyclerView.layoutManager = LinearLayoutManager(activity)

        val productListAdapter = ProductListFragmentAdapter(
            mutableListOf(
                Product(
                    1L, "feijao branco", "compal", 1,
                    Category(1,"Legumes","#000000"),false, 1
                ), Product(
                    2L, "arroz basmati", "continente", 2, Category(2,"Legumes","#fffddd"),true, 2
                )
            )
        )

        /*
        //Colocar informação da categoria
        //Construir layout horizontal para receber imagem e texto
        LinearLayout layoutCategoriesSubcategories = dialog.findViewById(R.id.dialogLayoutCategory);

        LinearLayout categoryLayout = LabelHorizontal.INSTANCE.createHorizontalLinearLayout(
                ctx, product.getCategory().getColor());

        Category cat = getCategoryBySequence(product.getCategory().getId());

        if(cat != null){
            categoryLayout.addView(LabelHorizontal.INSTANCE.createCircularImageView(ctx,
                    cat.getIcon()));
        }

        categoryLayout.addView(LabelHorizontal.INSTANCE.createTextView(ctx, product.getCategory().getName()));

        layoutCategoriesSubcategories.addView(categoryLayout);

        if(!product.getSubcategories().isEmpty()){

            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(ctx);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            horizontalScrollView.setLayoutParams(params);

            //Cria layout para subcategorias
            LinearLayout subcategoriesLayout = LabelHorizontal.INSTANCE.createParentHorizontalLinearLayout(ctx);

            for(Subcategory s: product.getSubcategories()){

                //Adiciona subcategorias ao layout

                LinearLayout subcategoryLayout = LabelHorizontal.INSTANCE.createHorizontalLinearLayout(
                        ctx, s.getColor());

                Subcategory subcategory = cat.getSubcategoryBySequence(s.getSequence());

                if(subcategory!=null){
                    subcategoryLayout.addView(LabelHorizontal.INSTANCE.createCircularImageView(ctx,
                            subcategory.getIcon()));
                }

                subcategoryLayout.addView(LabelHorizontal.INSTANCE.createTextView(ctx, s.getName()));

                subcategoriesLayout.addView(subcategoryLayout);
            }

            horizontalScrollView.addView(subcategoriesLayout);

            //Adicina layout ao principal
            layoutCategoriesSubcategories.addView(horizontalScrollView);



            public enum LabelHorizontal {

    INSTANCE;

    public LinearLayout createHorizontalLinearLayout(Context context, String color) {

        LinearLayout linearLayout = new LinearLayout(context);

        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.oval_label));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(5, 5, 5, 5);
        linearLayout.setLayoutParams(params);

        GradientDrawable categoryLayoutShape = (GradientDrawable) linearLayout.getBackground();
        categoryLayoutShape.mutate();
        categoryLayoutShape.setColor(Color.parseColor(color));

        return linearLayout;
    }

    public TextView createTextView(Context context, String text) {

        TextView title = new TextView(context);
        title.setTextColor(Color.WHITE);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setTextSize(15);
        title.setText(text);
        return title;
    }

    public CircleImageView createCircularImageView(Context context, Bitmap image) {

        CircleImageView circularImage = new CircleImageView(context);

        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(45, 45);

        circularImage.setImageBitmap(image);

        ((LinearLayout.LayoutParams) layoutParams).setMargins(0,0,2,0);

        circularImage.setLayoutParams(layoutParams);

        return circularImage;
    }


    public LinearLayout createParentHorizontalLinearLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);

        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(5, 5, 5, 5);
        linearLayout.setLayoutParams(params);

        return linearLayout;
    }
}

         */


        productRecyclerView.adapter = productListAdapter

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

