package ru.mirea.bakiev.data.room;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.bakiev.data.room.models.Recipe;

public class RoomRecipeDBController implements RecipeDBController{
    private RecipeDB recipeDB;
    private Context context;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RoomRecipeDBController(Context context) {
        this.context = context;

        recipeDB = Room.databaseBuilder(context, RecipeDB.class, "RecipeDB").build();
    }

    @Override
    public void getRecipe() {
        executorService.execute(() -> recipeDB.getRecipeDAO().getAllRecipes());
    }

    @Override
    public void addRecipe(Recipe recipe) {
        executorService.execute(() -> recipeDB.getRecipeDAO().addRecipe(recipe));
    }

    @Override
    public void deleteRecipe(int id) {
        executorService.execute(() -> recipeDB.getRecipeDAO().deleteRecipe(id));
    }
}
