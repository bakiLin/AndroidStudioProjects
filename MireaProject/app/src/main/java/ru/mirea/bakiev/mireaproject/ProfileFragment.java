package ru.mirea.bakiev.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.mirea.bakiev.mireaproject.databinding.FragmentMicrophoneBinding;
import ru.mirea.bakiev.mireaproject.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private EditText name;
    private EditText food;

    private Button saveButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentProfileBinding binding = FragmentProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        name = binding.nameEditText;
        food = binding.foodEditText;

        LoadProfileInfo();

        saveButton = binding.saveButton;
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getActivity().getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor	= sharedPref.edit();

                editor.putString("USER_NAME", name.getText().toString());
                editor.putString("FOOD", food.getText().toString());
                editor.apply();
            }
        });

        return view;
    }

    private void LoadProfileInfo() {
        SharedPreferences sharedPref = getActivity().getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        name.setText(sharedPref.getString("USER_NAME", ""));
        food.setText(sharedPref.getString("FOOD", ""));
    }
}