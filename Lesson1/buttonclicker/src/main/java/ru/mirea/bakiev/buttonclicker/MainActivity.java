package ru.mirea.bakiev.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button buttonWhoAmI;
    private Button buttonItsNotMe;
    private CheckBox chkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvOut);
        buttonWhoAmI = findViewById(R.id.btnWhoAmI);
        buttonItsNotMe = findViewById(R.id.btnItIsNotMe);
        chkBox = findViewById(R.id.checkBox);

        View.OnClickListener bWhoAmI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Мой номер по списку №3");
                chkBox.setChecked(true);
            }
        };
        buttonWhoAmI.setOnClickListener(bWhoAmI);
    }

    public void OnMyButtonClick(View view)
    {
        textView.setText("Eщё один способ!");
        chkBox.setChecked(false);
    }
}