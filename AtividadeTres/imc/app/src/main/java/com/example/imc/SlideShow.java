package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SlideShow extends AppCompatActivity {

    private int[] imagens = {R.drawable.cachorro, R.drawable.gardem, R.drawable.happy, R.drawable.patinho, R.drawable.porquinho};
    Button btnNext, btnLast;
    ImageView imageView;
    int posi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        imageView = findViewById(R.id.imageView2);
        btnLast = findViewById(R.id.btnLast);
        btnNext = findViewById(R.id.btnNext);
    }

    public void next_Click (View view){
        posi++;
        if (posi > imagens.length - 1){
            posi = 0;
        }
        Log.i("variavel", Integer.toString(posi));
        imageView.setImageResource(imagens[posi]);
    }

    public void last_Click (View view){
        posi--;
        if (posi < 0){
            posi = imagens.length - 1;
        }
        Log.i("variavel", Integer.toString(posi));
        imageView.setImageResource(imagens[posi]);
    }

    public void home_Click(View view){
        Intent intent = new Intent(this, PricipalActivity.class);

        startActivity(intent);
    }
}