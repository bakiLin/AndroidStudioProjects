package ru.mirea.bakiev.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView textView = (TextView) findViewById(R.id.textView);
        Bundle args = getIntent().getExtras();

        String str = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ " +
                3*3 + ", а текущее время " + args.get("time").toString();

        textView.setText(str);
    }
}