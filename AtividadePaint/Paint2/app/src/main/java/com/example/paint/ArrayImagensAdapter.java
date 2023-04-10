package com.example.paint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ArrayImagensAdapter extends ArrayAdapter<Integer> {
    Context mContext;
    int mLayout;
    Integer[] mListImg;
    SimplePaint sPaint;

    public ArrayImagensAdapter(@NonNull Context context, int resource, @NonNull Integer[] objects) {
        super(context, resource, objects);
        mContext = context;
        mLayout = resource;
        mListImg = objects;
    }

    @NonNull
    @Override
    public View getView(int positton, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
        ImageView ivGeometrico = view.findViewById(R.id.ivGeometrico);
        int img = (int) getItem(positton);
        ivGeometrico.setImageResource(img);
        return view;
    }

    @Override
    public View getDropDownView(int positton, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.geometricos_itens, parent, false);
        ImageView ivGeometrico = view.findViewById(R.id.ivGeometrico);
        int img = (int) getItem(positton);
        ivGeometrico.setImageResource(img);
        return view;
    }
}


