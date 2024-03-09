package ru.mirea.bakiev.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.status);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editText.setText("OnStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText("onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        editText.setText("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        editText.setText("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        editText.setText("onPause");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        editText.setText("onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        editText.setText("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        editText.setText("onDestroy");
    }
}