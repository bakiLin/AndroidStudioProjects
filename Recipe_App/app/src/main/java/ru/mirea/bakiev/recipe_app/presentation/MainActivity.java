package ru.mirea.bakiev.recipe_app.presentation;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.bakiev.recipe_app.R;
import ru.mirea.bakiev.recipe_app.data.repository.RecipeRepositoryImpl;
import ru.mirea.bakiev.recipe_app.data.repository.UserRepositoryImpl;
import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.models.User;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;
import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeRepository recipeRepository = new RecipeRepositoryImpl(Recipe.temp);
        recipeRepository.getRecipe();

        UserRepository userRepository = new UserRepositoryImpl(User.temp);
        userRepository.getUserInfo();
    }
}