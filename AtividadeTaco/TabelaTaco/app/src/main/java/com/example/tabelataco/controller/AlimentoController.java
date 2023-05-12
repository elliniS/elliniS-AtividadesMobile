package com.example.tabelataco.controller;

import android.content.Context;

import com.example.tabelataco.model.Alimento;
import com.example.tabelataco.model.AlimentoDao;

import java.util.ArrayList;

public class AlimentoController {
    Context mContext;
    AlimentoDao alimentoDao;

    public AlimentoController(Context context) {
        this.mContext = context;
        this.alimentoDao = new AlimentoDao(context);
    }

    public ArrayList<Alimento> listaAliimentos() {
        return  alimentoDao.getAlimentos();
    }

    public ArrayList<Alimento> listaAliimentosPesquisa(String pesguisa) {
        return alimentoDao.getAlimentos(pesguisa);
    }
}
