package com.example.shoppingcartfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddShippingDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddShippingDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText sAddr, sCity, sReg, sNat;
    Button sConfirm, sCancel;

    public AddShippingDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddShippingDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddShippingDetailsFragment newInstance(String param1, String param2) {
        AddShippingDetailsFragment fragment = new AddShippingDetailsFragment();
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
        return inflater.inflate(R.layout.fragment_add_shipping_details, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Get ViewModel
        ConcreteViewModel buyerViewModel = ViewModelProviders.of(getActivity()).get(ConcreteViewModel.class);
        // Pull seller class from sellerViewModel
        User buyer = buyerViewModel.getUser();
        String mySAddr, mySCity, mySReg, mySNat;
        mySAddr = sAddr.getText().toString();
        mySCity = sCity.getText().toString();
        mySReg = sReg.getText().toString();
        mySNat = sNat.getText().toString();
        sConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSD(mySAddr, mySCity, mySReg, mySNat, buyer);
            }
        });

    }
    public void addSD(String addr, String city, String reg, String nat, User buyer) {
        ShippingDetails shippingDetails = new ShippingDetails(addr, city, reg, nat);
        buyer.addObject(shippingDetails);
    }
}