package ru.mirea.bakiev.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Submit(View view) {
        EditText editText = (EditText)findViewById(R.id.input);
        int num = editText.getText().length();

        Toast.makeText(
                MainActivity.this, Integer.toString(num),
                Toast.LENGTH_SHORT
        ).show();
    }
}