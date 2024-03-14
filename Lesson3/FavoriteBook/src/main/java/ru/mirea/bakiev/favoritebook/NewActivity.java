package ru.mirea.bakiev.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle args = getIntent().getExtras();
        TextView textView = findViewById(R.id.textView2);
        textView.setText(args.get("name").toString());
    }

    public void SendBookName(View view) {
        EditText editText = findViewById(R.id.editTextText);

        Intent intent = new Intent();
        intent.putExtra("new_name", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}