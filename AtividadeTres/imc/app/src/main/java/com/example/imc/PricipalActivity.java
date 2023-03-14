package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PricipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricipal);
    }

    public void abreImc(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    public void abreSlideShow(View view){
        Intent intent = new Intent(this, SlideShow.class);

        startActivity(intent);
    }
}
