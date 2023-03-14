package com.example.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edPesso, edAltura;
    TextView textViewResultado;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPesso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
        imageView = findViewById(R.id.imageView);
        textViewResultado = findViewById(R.id.tvResultado);
    }

    public void calculaImc(View view){
        double pesso, altura, imc;

        pesso = Double.parseDouble(edPesso.getText().toString());
        altura = Double.parseDouble(edAltura.getText().toString());

        imc = pesso/(altura*altura);

        textViewResultado.setText(Double.toString(imc));

        if(imc < 18.5){
            imageView.setImageResource(R.drawable.abaixopeso);
        }else if (imc < 25) {
            imageView.setImageResource(R.drawable.normal);
        } else if (imc < 35) {
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc < 40) {
            imageView.setImageResource(R.drawable.obesidade2);
        }else {
            imageView.setImageResource(R.drawable.obesidade3);
        }

    }
}