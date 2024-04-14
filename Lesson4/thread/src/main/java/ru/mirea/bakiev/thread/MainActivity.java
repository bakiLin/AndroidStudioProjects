package ru.mirea.bakiev.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

import ru.mirea.bakiev.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());

        mainThread.setName("МОЙ НОМЕР ГРУППЫ: БСБО-10-21, НОМЕР ПО СПИСКУ: 3, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: Зеленая книга");
        infoTextView.append("\nНовое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));

        binding.buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int days = Integer.parseInt(binding.editTextDays.getText().toString());
                        int lessons = Integer.parseInt(binding.editTextLessons.getText().toString());

                        runOnUiThread(() -> {
                            float result = (float) lessons / (float) days;
                            binding.textViewResult.setText(String.valueOf(result));
                        });
                    }
                }).start();
            }
        });
    }
}