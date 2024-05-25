package ru.mirea.bakiev.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.mirea.bakiev.mireaproject.databinding.FragmentFirebaseInfoBinding;
import ru.mirea.bakiev.mireaproject.databinding.FragmentProfileBinding;

public class FirebaseInfoFragment extends Fragment {
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentFirebaseInfoBinding binding = FragmentFirebaseInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        binding.userIDtext.setText(user.getUid());
        binding.signOutFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(getActivity(), FirebaseActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}