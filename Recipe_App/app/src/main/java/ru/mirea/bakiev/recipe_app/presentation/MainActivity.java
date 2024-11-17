package ru.mirea.bakiev.recipe_app.presentation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.recipe_app.presentation.recyclers.RecipeRecyclerAdapter;
import ru.mirea.bakiev.recipe_app.presentation.viewModels.MainActivityViewModel;
import ru.mirea.bakiev.recipe_app.presentation.viewModels.MainActivityViewModelFactory;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private RecyclerView recipeRecyclerView;
    private RecipeRecyclerAdapter recipeRecyclerAdapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new MainActivityViewModelFactory(this))
                .get(MainActivityViewModel.class);

        recipeRecyclerView = findViewById(R.id.recipe_recycler);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recipeList = new ArrayList<>();
        recipeRecyclerAdapter = new RecipeRecyclerAdapter(recipeList);
        recipeRecyclerView.setAdapter(recipeRecyclerAdapter);

        viewModel.getRecipeLiveData().observe(this, this::setupRecipeDisplay);
        viewModel.getAllRecipe();
    }

    private void setupRecipeDisplay(List<Recipe> list) {
        recipeList.clear();
        recipeList.addAll(list);
        recipeRecyclerAdapter.notifyDataSetChanged();
    }
}