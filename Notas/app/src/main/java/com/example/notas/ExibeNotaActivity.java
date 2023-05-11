package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notas.controller.NotaController;
import com.example.notas.model.Nota;

public class ExibeNotaActivity extends AppCompatActivity {
    NotaController notaController;
    EditText edTitulo, edTexto;
    Bundle bundle;
    TextView tvDescrisao, tvId;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_nota);

        tvDescrisao = findViewById(R.id.tvDescrisao);
        tvId = findViewById(R.id.tvNotaId);
        edTitulo = findViewById(R.id.edTitulo);
        edTexto = findViewById(R.id.edTexto);
        bundle = getIntent().getExtras();
        id = Integer.parseInt(bundle.getString("id_nota"));

        notaController = new NotaController(getApplicationContext());

        if(id <= 0){
            tvDescrisao.setText("Nova Nota");
        }
        else{
            Nota nota = notaController.getNota(id);

            tvDescrisao.setText("Nota id:");
            tvId.setText(String.valueOf(id));
            edTitulo.setText(nota.getTitulo());
            edTexto.setText(nota.getTexto());
        }
    }

    public void salvarNota(View view){
        String retorno;
        if(id <= 0) {
            Nota n = notaController.cadastrarNovaNota(new Nota(edTitulo.getText().toString(), edTexto.getText().toString()));
            retorno = (n != null ? "Salvo com sucesso!" : "Não foi possivel salvar!");
        }
        else{
            boolean veri;
            veri = notaController.atualizaNota(new Nota(Integer.valueOf(tvId.getText().toString()), edTitulo.getText().toString(), edTexto.getText().toString()));
            retorno = (veri ? "Atualizado com sucesso!" : "Não foi possivel atualizar");
        }

        Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainNotaActivity.class);
        startActivity(intent);
    }
}