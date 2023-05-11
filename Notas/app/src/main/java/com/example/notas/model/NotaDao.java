package com.example.notas.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase database;
    public NotaDao(Context context) {
       database = context.openOrCreateDatabase("dbNotas", context.MODE_PRIVATE, null);
       database.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "titulo VARCHAR," +
                        "texto VARCHAR)");
    }

    public Nota inseriNota(Nota nota){
        ContentValues values = new ContentValues();

        values.put("titulo", nota.getTitulo());
        values.put("texto", nota.getTexto());
        int i = (int) database.insert("notas", null, values);
        nota.setId(i);
        return nota;
    }
    @SuppressLint("Range")
    public ArrayList<Nota> getListaNotas() {
        Cursor c = database.rawQuery("SELECT * FROM notas", null);
        ArrayList<Nota> result = new ArrayList<>();

        c.moveToFirst();
        while (!c.isAfterLast()){
            Nota nota = new Nota(c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("titulo")),
                    c.getString(c.getColumnIndex("texto")));
            result.add(nota);
            c.moveToNext();
        }
        return result;
    }
    @SuppressLint("Range")
    public Nota getNota(int id) {
        Cursor c = database.rawQuery("SELECT * FROM notas WHERE id = ?", new String[]{String.valueOf(id)});
        c.moveToFirst();
        Nota result = new Nota(id, c.getString(c.getColumnIndex("titulo")), c.getString(c.getColumnIndex("texto")));
        return result;
    }

    public boolean atualizaNota(Nota nota) {
        ContentValues values = new ContentValues();
        String where = "id = ?";
        values.put("titulo", nota.getTitulo());
        values.put("texto", nota.getTexto());

        return (0 != database.update("notas", values, where, new String[] {Integer.toString(nota.getId())}));
    }

    public boolean deleteNota(int id) {
        String where = "id = ?";
        return (0 != database.delete("notas", where, new String[] {Integer.toString(id)}));
    }
}
