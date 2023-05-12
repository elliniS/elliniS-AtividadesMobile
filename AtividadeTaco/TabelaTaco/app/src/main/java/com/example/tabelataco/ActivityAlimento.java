package com.example.tabelataco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tabelataco.controller.AlimentoController;
import com.example.tabelataco.model.Alimento;

public class ActivityAlimento extends AppCompatActivity {
    Bundle bundle;
    AlimentoController alimentoController;
    TextView tvid, tvCaterogia, tvAlimento, tvUmidade, tvEnergiakcal, tvkJ, tvProteonag, tvLipodeosg, tvColesterolmg, tvCarboidratosg;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento);

        tvid = findViewById(R.id.tvId);
        tvCaterogia = findViewById(R.id.tvCaterogia);
        tvAlimento = findViewById(R.id.tvAlimento);
        tvUmidade = findViewById(R.id.tvUmidade);
        tvEnergiakcal = findViewById(R.id.tvEnergiakcal);
        tvkJ = findViewById(R.id.tvkJ);
        tvProteonag = findViewById(R.id.tvProteonag);
        tvLipodeosg = findViewById(R.id.tvLipodeosg);
        tvColesterolmg = findViewById(R.id.tvColesterolmg);
        tvCarboidratosg = findViewById(R.id.tvCarboidratosg);

        bundle = getIntent().getExtras();
        id = Integer.parseInt(bundle.getString("id"));
        alimentoController = new AlimentoController(this);

        Alimento alimento = alimentoController.getAlimento(id);

        tvid.setText(String.valueOf(id));
        tvCaterogia.setText(alimento.getCaterogia());
        tvAlimento.setText(alimento.getAlimento());
        tvUmidade.setText(alimento.getUmidade());
        tvEnergiakcal.setText(alimento.getEnergiakcal());
        tvkJ.setText(alimento.getkJ());
        tvProteonag.setText(alimento.getProteonag());
        tvLipodeosg.setText(alimento.getLipodeosg());
        tvColesterolmg.setText(alimento.getColesterolmg());
        tvCarboidratosg.setText(alimento.getLipodeosg());
    }
}