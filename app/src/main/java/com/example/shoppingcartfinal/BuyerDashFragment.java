package com.example.shoppingcartfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuyerDashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyerDashFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button toShoppingCart;
    RecyclerView dashRV;
    View.OnClickListener onClickListener;

    public BuyerDashFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyerDashFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyerDashFragment newInstance(String param1, String param2) {
        BuyerDashFragment fragment = new BuyerDashFragment();
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
        View view = inflater.inflate(R.layout.fragment_buyer_dash, container, false);
        // Get ViewModel
        // To Shopping Cart button
        toShoppingCart = (Button) view.findViewById(R.id.toShoppingCart);
        dashRV = (RecyclerView) view.findViewById(R.id.drv);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        ProductDB productDB = new ProductDB(getContext());
        ProductViewModel productViewModel = ViewModelProviders.of(requireActivity()).get(ProductViewModel.class);

        // Initializes the RecyclerView list
        ProductAdapter productAdapter = new ProductAdapter(productDB.getProducts(), productViewModel);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dashRV.setLayoutManager(layoutManager);
        dashRV.setAdapter(productAdapter);

        toShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.shoppingCartFragment);
            }
        });
    }
}