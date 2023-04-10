package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SimplePaint sPaint;
    ImageView ivcolorPick, ivVoltaLinha, ivDescarta;
    SeekBar seekBar;
    Spinner spinner;
    Integer[] imgGeometricos = {R.drawable.linha, R.drawable.quadrado, R.drawable.circulo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sPaint = findViewById(R.id.simplePaint);
        ivcolorPick = findViewById(R.id.ivColorPicker);
        ivVoltaLinha = findViewById(R.id.ivVoltaLinha);
        ivDescarta = findViewById(R.id.ivDescarta);
        spinner = findViewById(R.id.spinner);
        ivcolorPick.setOnClickListener(this);
        ivVoltaLinha.setOnClickListener(this);
        ivDescarta.setOnClickListener(this);
        ivcolorPick.setColorFilter(Color.BLACK);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sPaint.currentPaint.setStrokeWidth(progress);
                sPaint.currentStroke = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       setForma(0);
        listaGeometricos();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setForma(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ivColorPicker:
                colorPickSelectColor();
                break;
            case R.id.ivVoltaLinha:
                voltarLinha();
                break;
            case R.id.ivDescarta:
                deleta();
                break;
        }
    }
    public void colorPickSelectColor(){
        new ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setColor(envelope);
                            }
                        })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

    private void setColor(ColorEnvelope envelope) {
        sPaint.setColor(Color.valueOf(envelope.getColor()));
        ivcolorPick.setColorFilter(Color.valueOf(envelope.getColor()).toArgb());
    }

    public void voltarLinha(){

        sPaint.voltaLinha();
    }

    public void deleta(){

        sPaint.deleta();
    }
    private void listaGeometricos(){
        spinner.setAdapter(
                new ArrayImagensAdapter(
                        getApplicationContext(),
                        R.layout.geometricos_itens,
                        imgGeometricos
                )
        );
    }

    private void setForma(int forma) {
        SimplePaint.Shape shape = null;
        switch(forma) {
            case 0:
                shape = SimplePaint.Shape.LINHA;
                break;
            case 1:
                shape = SimplePaint.Shape.QUADRADO;
                break;
            case 2:
                shape= SimplePaint.Shape.CIRCULO;
                break;
        }

        sPaint.setForma(shape);
    }

    @Override
    protected void onStart() {
        super.onStart();
        seekBar.setProgress((int) sPaint.currentPaint.getStrokeWidth());
    }
}