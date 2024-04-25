package ru.mirea.bakiev.mireaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment  = new WorkerFragment();
        //fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();

        //fragment = new CompassFragment();
        //fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();

        //fragment = new CameraFragment();
        //fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();

        fragment = new MicrophoneFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}