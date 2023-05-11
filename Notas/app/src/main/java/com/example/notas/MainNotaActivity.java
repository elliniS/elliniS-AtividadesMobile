package com.example.notas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.notas.controller.NotaController;

public class MainNotaActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{
    NotaController notaController;
    ListView listView;
    ImageButton btnEdita;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_main);

        notaController = new NotaController(this);
        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showNotas();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tvId = view.findViewById(R.id.tvId);
        new AlertDialog.Builder(this)
                .setPositiveButton( "Editar", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exibirNota(tvId.getText().toString());
                    }
                } )
                .setNegativeButton("Deletar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluirNota(Integer.valueOf(tvId.getText().toString()));
                    }
                })
                .setNeutralButton("Cancelar", null)
                .create()
                .show();
    }

    private void showNotas() {
        listView.setAdapter(
                new ArrayNotaAdapter(
                        getApplicationContext(),
                        R.layout.activity_list_view,
                        notaController.getListaNotas()
                )
        );
    }

    public void novaNota(View v){
        Intent intent = new Intent(this, ExibeNotaActivity.class);
        intent.putExtra("id_nota", "0");
        startActivity(intent);
    }


    public void exibirNota(String id){
        //notaController.getNota(id);

        Intent intent = new Intent(this, ExibeNotaActivity.class);
        intent.putExtra("id_nota", id);
        startActivity(intent);
    }
    private void excluirNota(int id) {
        notaController.excluirNota(id);
        showNotas();
    }
}