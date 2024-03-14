package ru.mirea.bakiev.simplefragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment frag1, frag2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new FirstFragment();
        frag2 = new SecondFragment();
    }

    public void OnClick(View view) {
        fragmentManager = getSupportFragmentManager();

        if (view.getId() == R.id.button1) {
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, frag1).commit();
        } else if (view.getId() == R.id.button2) {
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, frag2).commit();
        }
    }
}