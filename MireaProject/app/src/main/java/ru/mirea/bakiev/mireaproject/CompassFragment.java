package ru.mirea.bakiev.mireaproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CompassFragment extends Fragment implements SensorEventListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compass, container, false);
    }

    private TextView azimuthText;
    private TextView reverseAzimuthText;
    private SensorManager sensorManager;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        azimuthText = view.findViewById(R.id.azimuthText);
        reverseAzimuthText = view.findViewById(R.id.reverseAzimuthText);
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            azimuthText.setText("Азимут: " + Math.round(event.values[0]));

            float temp = 0;
            if (event.values[0] > 180) temp = event.values[0] - 180;
            else temp = event.values[0] + 180;

            reverseAzimuthText.setText("Обратный азимут: " + Math.round(temp));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) { }
}