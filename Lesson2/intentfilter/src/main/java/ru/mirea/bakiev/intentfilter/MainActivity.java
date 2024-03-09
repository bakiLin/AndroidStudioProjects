package ru.mirea.bakiev.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToMirea(View view) {
        Uri add = Uri.parse("https://www.mirea.ru/");
        Intent link = new Intent(Intent.ACTION_VIEW, add);
        startActivity(link);
    }

    public void ShareInfo(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Бакиев Ильнур Шерзодович");
        startActivity(Intent.createChooser(shareIntent, "Мои ФИО"));
    }
}