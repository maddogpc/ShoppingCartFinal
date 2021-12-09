package com.example.shoppingcartfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView textView, totalCost, existingCard, existingAddress;
    Button addCard, addShippingDetails, proceed, back;

    public CheckoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckoutFragment newInstance(String param1, String param2) {
        CheckoutFragment fragment = new CheckoutFragment();
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
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);
        // Inflate the text views
        existingCard = (TextView) view.findViewById(R.id.existingCard);
        existingAddress = (TextView) view.findViewById(R.id.existingSD);
        // Inflate the buttons
        addCard = (Button) view.findViewById(R.id.addCard);
        addShippingDetails = (Button) view.findViewById(R.id.addSD);
        proceed = (Button) view.findViewById(R.id.proceed);
        back = (Button) view.findViewById(R.id.back);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Pull objects from ViewModel
        ConcreteViewModel concreteViewModel = ViewModelProviders.of(getActivity()).get(ConcreteViewModel.class);
        ShoppingCartViewModel shoppingCartViewModel = ViewModelProviders.of(getActivity()).get(ShoppingCartViewModel.class);
        User buyer = concreteViewModel.getUser();
        ShoppingCart shoppingCart = shoppingCartViewModel.getShoppingCart();
        Card card = (Card) buyer.getObject("Card");
        ShippingDetails shippingDetails = (ShippingDetails) buyer.getObject("ShippingDetails");
        if (card != null)
        {
            existingCard.setText("Existing card " + card.getCarNum());
        }
        else
        {
            existingCard.setText("No card available");
        }
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.addCardFragment);
            }
        });
        if (shippingDetails != null)
        {
            existingAddress.setText("Existing shipping details " + shippingDetails.getAddress());
        }
        else
        {
            existingAddress.setText("No address available");
        }
        addShippingDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.addShippingDetailsFragment);
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (card == null || shippingDetails == null)
                {
                    Toast.makeText(getContext(), "Card and Shipping details are required before placing an order", Toast.LENGTH_SHORT);
                }
                else
                {
                    createOrder(buyer, card, shippingDetails, shoppingCart.getProducts());
                    Navigation.findNavController(view).navigate(R.id.confirmOrderFragment);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.shoppingCartFragment);
            }
        });

    }
    public void createOrder(User buyer, Card card, ShippingDetails shippingDetails, ArrayList<Product> products) {
        OrderViewModel orderViewModel = ViewModelProviders.of(getActivity()).get(OrderViewModel.class);
        Order order = new Order(buyer.getName(), buyer.getEmail(), card, shippingDetails, products);
        orderViewModel.setOrder(order);
    }
}