package ru.mirea.bakiev.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView textView = (TextView)findViewById(R.id.textView);
        Bundle args = getIntent().getExtras();
        textView.setText(args.get("input").toString());
    }
}