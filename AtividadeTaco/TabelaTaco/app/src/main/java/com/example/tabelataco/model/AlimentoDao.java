package com.example.tabelataco.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tabelataco.BancoTaco;

import java.util.ArrayList;

public class AlimentoDao {
    SQLiteDatabase sqLiteDatabase;
    public AlimentoDao(Context context) {
        BancoTaco bancoTaco = new BancoTaco(context);
        sqLiteDatabase = bancoTaco.getWritableDatabase();

    }

    @SuppressLint("Range")
    public ArrayList<Alimento> getAlimentos() {
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM taco_4___edicao", null);
        ArrayList<Alimento> result = new ArrayList<>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            Alimento alimento = new Alimento(Integer.valueOf(c.getString(c.getColumnIndex("id"))),
                    c.getString(c.getColumnIndex("Caterogia")),
                    c.getString(c.getColumnIndex("Alimento")),
                    c.getString(c.getColumnIndex("Umidade")),
                    c.getString(c.getColumnIndex("Energiakcal")),
                    c.getString(c.getColumnIndex("kJ")),
                    c.getString(c.getColumnIndex("Proteonag")),
                    c.getString(c.getColumnIndex("Lipodeosg")),
                    c.getString(c.getColumnIndex("Colesterolmg")),
                    c.getString(c.getColumnIndex("Carboidratosg")));
            result.add(alimento);
            c.moveToNext();
        }
        return result;
    }

    @SuppressLint("Range")
    public ArrayList<Alimento> getAlimentos(String pesguisa) {
        String sql = "SELECT * FROM taco_4___edicao WHERE Alimento LIKE ?";
        Cursor c = sqLiteDatabase.rawQuery(sql, new String[] {"%" + pesguisa + "%"});
        ArrayList<Alimento> result = new ArrayList<>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            Alimento alimento = new Alimento(Integer.valueOf(c.getString(c.getColumnIndex("id"))),
                    c.getString(c.getColumnIndex("Caterogia")),
                    c.getString(c.getColumnIndex("Alimento")),
                    c.getString(c.getColumnIndex("Umidade")),
                    c.getString(c.getColumnIndex("Energiakcal")),
                    c.getString(c.getColumnIndex("kJ")),
                    c.getString(c.getColumnIndex("Proteonag")),
                    c.getString(c.getColumnIndex("Lipodeosg")),
                    c.getString(c.getColumnIndex("Colesterolmg")),
                    c.getString(c.getColumnIndex("Carboidratosg")));
            result.add(alimento);
            c.moveToNext();
        }
        return result;
    }

    @SuppressLint("Range")
    public Alimento getAlimento(int id) {
        String sql = "SELECT * FROM taco_4___edicao WHERE id = ?";
        Cursor c = sqLiteDatabase.rawQuery(sql, new String[] {String.valueOf(id)});
        c.moveToFirst();
        Alimento result = new Alimento(Integer.valueOf(c.getString(c.getColumnIndex("id"))),
                c.getString(c.getColumnIndex("Caterogia")),
                c.getString(c.getColumnIndex("Alimento")),
                c.getString(c.getColumnIndex("Umidade")),
                c.getString(c.getColumnIndex("Energiakcal")),
                c.getString(c.getColumnIndex("kJ")),
                c.getString(c.getColumnIndex("Proteonag")),
                c.getString(c.getColumnIndex("Lipodeosg")),
                c.getString(c.getColumnIndex("Colesterolmg")),
                c.getString(c.getColumnIndex("Carboidratosg")));

        return result;
    }
}
