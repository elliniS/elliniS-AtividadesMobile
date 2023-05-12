package com.example.notas.controller;

import android.content.Context;

import com.example.notas.model.Nota;
import com.example.notas.model.NotaDao;

import java.util.ArrayList;

public class NotaController {
    Context mContext;
    private NotaDao notaDao;

    public NotaController(Context context){
        mContext = context;
        notaDao = new NotaDao(context);
    }

    public Nota cadastrarNovaNota(Nota nota){
        return  notaDao.inseriNota(nota);
    }

    public ArrayList<Nota> getListaNotas(){
        return notaDao.getListaNotas();
    }

    public Nota getNota(int id) {
        return  notaDao.getNota(id);
    }

    public boolean atualizaNota(Nota nota) {
        return notaDao.atualizaNota(nota);
    }

    public boolean excluirNota(int id) {
        return notaDao.deleteNota(id);
    }

    public ArrayList<Nota> getListaNotas(String pesguisa) {
        return notaDao.getListaNotas(pesguisa);
    }
}
