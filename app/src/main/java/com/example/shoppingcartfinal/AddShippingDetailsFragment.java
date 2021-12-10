package com.example.shoppingcartfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

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

    EditText sAddr, sCity, sReg, sNat, sZIP;
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
        View view = inflater.inflate(R.layout.fragment_add_shipping_details, container, false);
        sAddr = (EditText) view.findViewById(R.id.addr);
        sCity = (EditText) view.findViewById(R.id.city);
        sReg = (EditText) view.findViewById(R.id.reg);
        sNat = (EditText) view.findViewById(R.id.nat);
        sZIP = (EditText) view.findViewById(R.id.zip);
        sConfirm = (Button) view.findViewById(R.id.confirmAddr);
        sCancel = (Button) view.findViewById(R.id.cancelAddr);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        // Get ViewModel
        ConcreteViewModel buyerViewModel = ViewModelProviders.of(getActivity()).get(ConcreteViewModel.class);
        // Pull seller class from sellerViewModel
        User buyer = buyerViewModel.getUser();
        sConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final String mySAddr = sAddr.getText().toString();
                    final String mySCity = sCity.getText().toString();
                    final String mySReg = sReg.getText().toString();
                    final String mySNat = sNat.getText().toString();
                    final String mySZIP = sZIP.getText().toString();
                    addSD(mySAddr, mySCity, mySReg, mySNat, mySZIP, buyer);
                    Navigation.findNavController(view).navigate(R.id.checkoutFragment);
                } catch (NumberFormatException n) {
                    n.printStackTrace();
                    Toast.makeText(getContext(), "No input on either field", Toast.LENGTH_SHORT);
                } catch (NullPointerException n) {
                    n.printStackTrace();
                    Toast.makeText(getContext(), "No input on either field", Toast.LENGTH_SHORT);
                }
            }
        });
        sCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.checkoutFragment);
            }
        });
    }

    public void addSD(String addr, String city, String reg, String nat, String ZIP, User buyer) {
        ShippingDetails shippingDetails = new ShippingDetails(addr, city, reg, nat, ZIP);
        buyer.addObject(shippingDetails);
    }
}