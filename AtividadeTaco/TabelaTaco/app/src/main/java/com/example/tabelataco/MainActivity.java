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

import com.example.tabelataco.controller.AlimentoController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SQLiteDatabase sqLiteDatabase;
    ListView listView;

    AlimentoController alimentoController;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);
        alimentoController = new AlimentoController(this);

        searchView.setOnQueryTextListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listView.setAdapter(
                new ArrayAlimentoAdapter(
                        getApplicationContext(),
                        R.layout.activity_alimento_item,
                        alimentoController.listaAliimentos()
                )
        );
   }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listView.setAdapter(
                new ArrayAlimentoAdapter(
                        getApplicationContext(),
                        R.layout.activity_alimento_item,
                        alimentoController.listaAliimentosPesquisa(newText)
                )
        );
        return false;
    }
}