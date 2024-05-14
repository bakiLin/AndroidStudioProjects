package ru.mirea.bakiev.mireaproject;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import ru.mirea.bakiev.mireaproject.databinding.FragmentWorkWithFilesBinding;

public class WorkWithFilesFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private EditText fileName;
    private EditText content;
    private Button loadButton;
    private FloatingActionButton floatingButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentWorkWithFilesBinding binding = FragmentWorkWithFilesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        fileName = binding.fileName;
        content = binding.content;
        loadButton = binding.loadButton;
        floatingButton = binding.floatingButton;

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fin = null;
                try {
                    fin = getContext().openFileInput(fileName.getText().toString());
                    byte[] bytes = new byte[fin.available()];
                    fin.read(bytes);

                    String content = Decrypt(new String(bytes));
                    WorkWithFilesFragment.this.content.setText(content);
                } catch (IOException ex) {
                    Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        if (fin != null)
                            fin.close();
                    } catch (IOException ex) {
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popup, null);

                final PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1000, true);

                TextView title = popupView.findViewById(R.id.currentFileName);
                TextView contentEncrypted = popupView.findViewById(R.id.currentFileContent);

                title.setText(String.format(fileName.getText().toString()));
                contentEncrypted.setText(new String(Encrypt(content.getText().toString()), StandardCharsets.UTF_8));

                Button saveButton = popupView.findViewById(R.id.saveButton);
                saveButton.setOnClickListener(view1 -> {
                    saveToFile();
                    popupWindow.dismiss();
                });

                if (fileName.getText().toString().length() < 1 || content.getText().toString().length() < 1)
                    saveButton.setEnabled(false);
                else
                    saveButton.setEnabled(true);

                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
            }
        });

        return view;
    }

    private String Decrypt(String content) {
        try {
            return new String(Base64.decode(content, Base64.DEFAULT));
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return "";
    }

    private byte[] Encrypt(String text) {
        try {
            return Base64.encode(text.getBytes(), Base64.DEFAULT);
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return "".getBytes();
    }

    private void saveToFile() {
        String content = this.content.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = getContext().openFileOutput(fileName.getText().toString(), Context.MODE_PRIVATE);
            outputStream.write(new String(Encrypt(content), StandardCharsets.UTF_8).getBytes());
            outputStream.close();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}