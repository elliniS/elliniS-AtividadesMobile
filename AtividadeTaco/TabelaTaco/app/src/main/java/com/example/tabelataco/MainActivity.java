package com.example.tabelataco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SQLiteDatabase sqLiteDatabase;
    ListView listView;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);
        inicializaDataBase();

        searchView.setOnQueryTextListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listView.setAdapter(
                new ArrayAdapter<>(
                        getApplicationContext(),
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        listaAliimentos()
                )
        );
   }

    public void inicializaDataBase(){
            BancoTaco bancoTaco = new BancoTaco(this);
            sqLiteDatabase = bancoTaco.getWritableDatabase();
    }

    @SuppressLint("Range")
    private ArrayList<String> listaAliimentos() {
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM taco_4___edicao", null);
        ArrayList<String> result = new ArrayList<>();

        c.moveToFirst();
        while (!c.isAfterLast()){
            result.add(c.getString(c.getColumnIndex("Alimento")));
            c.moveToNext();
        }
        return result;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listView.setAdapter(
                new ArrayAdapter<>(
                        getApplicationContext(),
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        listaAliimentosPesquisa(newText)
                )
        );
        return false;
    }
    @SuppressLint("Range")
    private ArrayList<String> listaAliimentosPesquisa(String pesguisa){
        String sql = "SELECT * FROM taco_4___edicao WHERE Alimento LIKE ?";

        Cursor c = sqLiteDatabase.rawQuery(sql, new String[] {"%" + pesguisa + "%"});
        ArrayList<String> result = new ArrayList<>();


        c.moveToFirst();
        while (!c.isAfterLast()){
            result.add(c.getString(c.getColumnIndex("Alimento")));
            c.moveToNext();
        }
        return result;
    }
}