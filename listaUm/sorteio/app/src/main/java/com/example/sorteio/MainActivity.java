package com.example.sorteio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText numMax, numMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        numMax = findViewById(R.id.txtNumMax);
        numMin = findViewById(R.id.txtNumMin);
    }

    public void sorteia(View view){

        int sort = sorteiaValor(Integer.parseInt(numMin.getText().toString()), Integer.parseInt(numMax.getText().toString()));

        textView.setText(Integer.toString(sort));
    }
    public int sorteiaValor(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }

}