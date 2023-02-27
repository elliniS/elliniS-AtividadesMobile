package com.example.contaclique;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView= findViewById(R.id.quantClick);
        i = 0;
        textView.setText(Integer.toString(i));
    }

    public void contaClick(View view){
        i++;
        textView.setText(Integer.toString(i));
    }
}