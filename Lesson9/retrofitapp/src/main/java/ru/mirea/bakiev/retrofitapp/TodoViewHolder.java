package ru.mirea.bakiev.retrofitapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends	RecyclerView.ViewHolder {
    ImageView image;
    TextView title;
    CheckBox checkBox;

    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        checkBox = itemView.findViewById(R.id.checkBox);
    }
}
