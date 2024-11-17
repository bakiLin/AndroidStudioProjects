package ru.mirea.bakiev.recipe_app.presentation.recyclers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.R;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecipeViewHolder>{
    private List<Recipe> recipeList;
    private Context context;

    public RecipeRecyclerAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cell, parent, false);

        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);

        holder.getTextView().setText(recipe.getName());

        int resID = context.getResources().getIdentifier(recipe.getImg(), "drawable", context.getPackageName());
        holder.getImageView().setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
