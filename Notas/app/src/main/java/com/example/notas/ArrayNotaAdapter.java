package com.example.notas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.notas.model.Nota;

import java.util.ArrayList;

public class ArrayNotaAdapter extends android.widget.ArrayAdapter<Nota> {
    Context mContext;
    int mLayout;
    ArrayList<Nota> mNotas;

    public ArrayNotaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Nota> objects) {
        super(context, resource, objects);

        mContext = context;
        mLayout = resource;
        mNotas = objects;
    }

    @NonNull
    @Override
    public View getView(int positton, @NonNull View view, @NonNull ViewGroup parent) {
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(mLayout, parent, false);
        }
        Nota nota = getItem(positton);
        TextView tvId = view.findViewById(R.id.tvId);
        TextView tvTitulo = view.findViewById(R.id.tvTituloList);

        tvId.setText(Integer.toString(nota.getId()));
        tvTitulo.setText(nota.getTitulo());

        return view;
    }
}
