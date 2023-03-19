package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FragmentoA fragmentoA;
    FragmentoB fragmentoB;
    FragmentoC fragmentoC;

    Button qudrado, triangulo, circulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentoA = new FragmentoA();
        fragmentoB = new FragmentoB();
        fragmentoC = new FragmentoC();

        qudrado = findViewById(R.id.btnQuadrado);
        triangulo = findViewById(R.id.btnTriangulo);
        circulo = findViewById(R.id.btnCirculo);
        qudrado.setOnClickListener(this);
        circulo.setOnClickListener(this);
        triangulo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnQuadrado:
                fTransaction.replace(R.id.fragmentContainerView, fragmentoA);
                fTransaction.addToBackStack(null);
                break;
            case R.id.btnTriangulo:
                fTransaction.replace(R.id.fragmentContainerView, fragmentoB);
                fTransaction.addToBackStack(null);
                break;
            case R.id.btnCirculo:
                fTransaction.replace(R.id.fragmentContainerView, fragmentoC);
                fTransaction.addToBackStack(null);
        }

        fTransaction.commit();
    }
}