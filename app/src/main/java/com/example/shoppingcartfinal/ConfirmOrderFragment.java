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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmOrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView orderedList;
    Button confirmOrder, cancelOrder;
    TextView buyerName, cardNumber, address, city_region_country, zipCode, totalSpend;

    public ConfirmOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmOrderFragment newInstance(String param1, String param2) {
        ConfirmOrderFragment fragment = new ConfirmOrderFragment();
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
        View view = inflater.inflate(R.layout.fragment_confirm_order, container, false);
        // Inflate the text views
        buyerName = (TextView) view.findViewById(R.id.buyerName);
        cardNumber = (TextView) view.findViewById(R.id.cardNumber);
        address = (TextView) view.findViewById(R.id.address);
        city_region_country = (TextView) view.findViewById(R.id.city_reg_nat);
        zipCode = (TextView) view.findViewById(R.id.zipCode);
        totalSpend = (TextView) view.findViewById(R.id.totalCost);
        // Inflate the buttons
        confirmOrder = (Button) view.findViewById(R.id.confirmOrder);
        cancelOrder = (Button) view.findViewById(R.id.cancelOrder);
        // Inflate the RecyclerView
        orderedList = (RecyclerView) view.findViewById(R.id.orderList);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        OrderViewModel orderViewModel = ViewModelProviders.of(getActivity()).get(OrderViewModel.class);
        Order order = orderViewModel.getOrder();
        if (order != null)
        {
            buyerName.setText("Orderer: " + order.getBuyerName() + "(" + order.getBuyerEmail() + ")");
            cardNumber.setText("Card: " + order.getCardInfo().getCarNum());
            address.setText("Address: " + order.getShippingDetails().getAddress());
            city_region_country.setText(order.getShippingDetails().getCity() + " " + order.getShippingDetails().getRegion() + " " + order.getShippingDetails().getCountry());
            zipCode.setText(order.getShippingDetails().getZip());

            // Initializes the RecyclerView list
            OrderAdapter orderAdapter = new OrderAdapter(order.getProducts());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            orderedList.setLayoutManager(layoutManager);
            orderedList.setAdapter(orderAdapter);

            totalSpend.setText(Double.toString(order.getTotalCostCost()));
            confirmOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderDB orderDB = OrderDB.getInstance(getContext());
                    orderDB.addOrder(order);
                    orderDB.saveDB(false);
                    Navigation.findNavController(view).navigate(R.id.buyerDashFragment);
                }
            });
            cancelOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.checkoutFragment);
                }
            });
        }
    }
}