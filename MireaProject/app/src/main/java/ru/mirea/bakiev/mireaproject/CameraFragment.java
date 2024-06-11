package ru.mirea.bakiev.mireaproject;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import ru.mirea.bakiev.mireaproject.databinding.FragmentCameraBinding;

public class CameraFragment extends Fragment {
    private	static final int REQUEST_CODE_PERMISSION = 100;
    private Uri imageUriOne;
    private Uri imageUriTwo;
    private Uri imageUriThree;
    private Uri imageUriFour;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int cameraPermissionStatus = ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.CAMERA);
        int storagePermissionStatus = ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (cameraPermissionStatus != PackageManager.PERMISSION_GRANTED &&
                storagePermissionStatus != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, REQUEST_CODE_PERMISSION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentCameraBinding binding = FragmentCameraBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        ActivityResultCallback<ActivityResult> callback	= result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                binding.imageOne.setImageURI(imageUriOne);
                binding.imageTwo.setImageURI(imageUriTwo);
                binding.imageThree.setImageURI(imageUriThree);
                binding.imageFour.setImageURI(imageUriFour);
            }
        };

        ActivityResultLauncher<Intent> cameraActivityResultLauncher	= registerForActivityResult(
                new	ActivityResultContracts.StartActivityForResult(),
                callback);

        binding.imageOne.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try	{
                File file = createImageFile();
                String authorities = getActivity().getApplicationContext().getPackageName() + ".fileprovider";
                imageUriOne = FileProvider.getUriForFile(getActivity(), authorities, file);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriOne);
                cameraActivityResultLauncher.launch(cameraIntent);
            } catch	(IOException e)	{
                e.printStackTrace();
            }
        });

        binding.imageTwo.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try	{
                File file = createImageFile();
                String authorities = getActivity().getApplicationContext().getPackageName() + ".fileprovider";
                imageUriTwo = FileProvider.getUriForFile(getActivity(), authorities, file);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriTwo);
                cameraActivityResultLauncher.launch(cameraIntent);
            } catch	(IOException e)	{
                e.printStackTrace();
            }
        });

        binding.imageThree.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try	{
                File file = createImageFile();
                String authorities = getActivity().getApplicationContext().getPackageName() + ".fileprovider";
                imageUriThree = FileProvider.getUriForFile(getActivity(), authorities, file);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriThree);
                cameraActivityResultLauncher.launch(cameraIntent);
            } catch	(IOException e)	{
                e.printStackTrace();
            }
        });

        binding.imageFour.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try	{
                File file = createImageFile();
                String authorities = getActivity().getApplicationContext().getPackageName() + ".fileprovider";
                imageUriFour = FileProvider.getUriForFile(getActivity(), authorities, file);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriFour);
                cameraActivityResultLauncher.launch(cameraIntent);
            } catch	(IOException e)	{
                e.printStackTrace();
            }
        });

        return view;
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        String imageFileName = "IMAGE_" + timeStamp + "_";
        File storageDirectory =	getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(imageFileName, ".jpg",	storageDirectory);
    }
}