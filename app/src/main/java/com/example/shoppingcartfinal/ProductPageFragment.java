package com.example.shoppingcartfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView productName, productCost, productDesc, productProvider;
    Button addToCart, cancel;

    public ProductPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductPageFragment newInstance(String param1, String param2) {
        ProductPageFragment fragment = new ProductPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_page, container, false);
        productName = (TextView) view.findViewById(R.id.thisProductName);
        productCost = (TextView) view.findViewById(R.id.thisProductCost);
        productDesc = (TextView) view.findViewById(R.id.thisProductDesc);
        productProvider = (TextView) view.findViewById(R.id.productSellerName);
        addToCart = (Button) view.findViewById(R.id.addProductToCart);
        cancel = (Button) view.findViewById(R.id.cancelAdd);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Pull product details and shopping cart from their respective View Models
        ProductViewModel productViewModel = ViewModelProviders.of(getActivity()).get(ProductViewModel.class);
        ShoppingCartViewModel shoppingCartViewModel = ViewModelProviders.of(getActivity()).get(ShoppingCartViewModel.class);
        Product product = productViewModel.getProduct();
        ShoppingCart shoppingCart = ShoppingCart.getInstance();
        // Set text of product details
        productName.setText(product.getName());
        productCost.setText(Double.toString(product.getCost()));
        productDesc.setText(product.getDescription());
        productProvider.setText(product.getSeller());
        // Click listener to add product to shopping cart
        System.out.println("ee" + shoppingCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCart.addToShoppingCart(product);
                Navigation.findNavController(view).navigate(R.id.buyerDashFragment);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.buyerDashFragment);
            }
        });
    }
}