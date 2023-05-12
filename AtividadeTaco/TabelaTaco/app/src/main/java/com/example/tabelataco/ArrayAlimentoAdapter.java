package com.example.tabelataco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tabelataco.model.Alimento;

import java.util.ArrayList;

public class ArrayAlimentoAdapter extends ArrayAdapter<Alimento> {
    Context mContext;
    int mLayout;
    ArrayList<Alimento> mAlimentos;

    public ArrayAlimentoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Alimento> objects) {
        super(context, resource, objects);

        mContext = context;
        mLayout = resource;
        mAlimentos = objects;
    }

    @NonNull
    @Override
    public View getView(int positton, @NonNull View view, @NonNull ViewGroup parent) {
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(mLayout, parent, false);
        }
        Alimento alimento = getItem(positton);
        TextView tvId = view.findViewById(R.id.tvIdList);
        TextView tvAlimento = view.findViewById(R.id.tvAlimentoList);

        tvId.setText(Integer.toString(alimento.getId()));
        tvAlimento.setText(alimento.getAlimento());

        return view;
    }
}
