package ru.mirea.bakiev.favoritebook;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String bookName = "book_name";
    private TextView textView;
    private ActivityResultLauncher<Intent> arl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        ActivityResultCallback<ActivityResult> callback = result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                bookName = data.getStringExtra("new_name");
                textView.setText(bookName);
            }
        };

        arl = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), callback);
    }

    public void SetBookName(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("name", bookName);
        arl.launch(intent);
    }
}