package ru.mirea.bakiev.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendTime(View view) {
        Intent intent = new Intent(".SecondActivity");
        intent.putExtra("time", GetSystemTime());
        startActivity(intent);
    }

    private String GetSystemTime() {
        long dateInMillis = System.currentTimeMillis();
        String format = "HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(dateInMillis));
    }
}