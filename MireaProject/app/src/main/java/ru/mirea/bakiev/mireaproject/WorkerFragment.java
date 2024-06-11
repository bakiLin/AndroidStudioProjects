package ru.mirea.bakiev.mireaproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WorkerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        WorkManager
                .getInstance(getActivity())
                .enqueue(workRequest);

        return inflater.inflate(R.layout.fragment_worker, container, false);
    }
}