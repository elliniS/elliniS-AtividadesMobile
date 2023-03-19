package com.example.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentoC extends Fragment implements View.OnClickListener{
    Button buttonAbreA;

    public FragmentoC() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_c, container, false);
        buttonAbreA = view.findViewById(R.id.btnVoltar);
        buttonAbreA.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentoA fragmentoA = new FragmentoA();
        FragmentTransaction fTransaction = getParentFragmentManager().beginTransaction();

        fTransaction.replace(R.id.fragmentContainerView, fragmentoA);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }
}