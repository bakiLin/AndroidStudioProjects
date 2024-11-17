package ru.mirea.bakiev.recipe_app.presentation.recyclers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.bakiev.recipe_app.R;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView text;
    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image);
        text = itemView.findViewById(R.id.title);
    }

    public ImageView getImageView() {
        return image;
    }

    public TextView getTextView() {
        return text;
    }
}
