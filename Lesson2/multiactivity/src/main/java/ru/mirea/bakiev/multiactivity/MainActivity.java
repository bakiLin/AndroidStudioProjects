package ru.mirea.bakiev.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NextPage(View view) {
        Intent intent = new Intent(".SecondActivity");
        intent.putExtra("input", GetInputValue());
        startActivity(intent);
    }

    private String GetInputValue() {
        EditText editText = (EditText)findViewById(R.id.inputData);
        return editText.getText().toString();
    }
}