package com.example.termometro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor mSensorTemperatura;
    TextView tvTemperatura;
    ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstraintLayout = findViewById(R.id.constraintLayout);
        tvTemperatura = findViewById(R.id.tvTemperatura);
        mSensorManager = (SensorManager) getSystemService(getApplication().SENSOR_SERVICE);
        mSensorTemperatura = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorManager.registerListener(this, mSensorTemperatura, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float currentValue = event.values[0];
        tvTemperatura.setText(Float.toString(currentValue));
        int color = getColor(currentValue);
        mConstraintLayout.setBackgroundColor(color);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private int getColor(float temp) {
        float minTemp = 10.0f;
        float maxTemp = 30.0f;
        int startColor = Color.BLUE;
        int endColor = Color.RED;

        if(temp > 30.0f){
            temp = 30.0f;
        }
        else if (temp < 10.0f) {
            temp = 10.0f;
        }

        float position = (temp - minTemp) / (maxTemp - minTemp);

        int red = (int) (Color.red(startColor) + (Color.red(endColor) - Color.red(startColor)) * position);
        int green = (int) (Color.green(startColor) + (Color.green(endColor) - Color.green(startColor)) * position);
        int blue = (int) (Color.blue(startColor) + (Color.blue(endColor) - Color.blue(startColor)) * position);

        return Color.argb(255,red, green, blue);
    }

}