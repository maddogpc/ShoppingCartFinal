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
 * Use the {@link AddCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText cNum, cExp, cPin, cH;
    Button cConfirm, cCancel;

    public AddCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCardFragment newInstance(String param1, String param2) {
        AddCardFragment fragment = new AddCardFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_card, container, false);
        cNum = (EditText) view.findViewById(R.id.cnum);
        cExp = (EditText) view.findViewById(R.id.cexp);
        cPin = (EditText) view.findViewById(R.id.cnum);
        cConfirm = (Button) view.findViewById(R.id.confirmCard);
        cCancel = (Button) view.findViewById(R.id.cancelCard);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        // Get ViewModel
        ConcreteViewModel buyerViewModel = ViewModelProviders.of(getActivity()).get(ConcreteViewModel.class);
        // Pull seller class from sellerViewModel
        User buyer = buyerViewModel.getUser();
        String myCNum, myExp, myPin, myCH;
        myCNum = cNum.getText().toString();
        myExp = cExp.getText().toString();
        myPin = cPin.getText().toString();
        cConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCard(myCNum, myExp, myPin, buyer);
            }
        });

    }
    public void addCard(String num, String exp, String pin, User buyer) {
        Card card = new Card(num, exp, pin, buyer.getName());
        buyer.addObject(card);
    }
}