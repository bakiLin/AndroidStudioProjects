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
        //fragment = new CompassFragment();
        //fragment = new CameraFragment();
        //fragment = new MicrophoneFragment();
        //fragment = new ProfileFragment();
        //fragment = new WorkWithFilesFragment();
        //fragment = new FirebaseInfoFragment();
        fragment = new PlacesFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}