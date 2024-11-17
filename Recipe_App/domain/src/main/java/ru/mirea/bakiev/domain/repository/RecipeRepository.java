package ru.mirea.bakiev.domain.repository;

import java.util.List;

import ru.mirea.bakiev.domain.ApiCallback;
import ru.mirea.bakiev.domain.models.Recipe;

public interface RecipeRepository {
    public void getAllRecipes(ApiCallback<List<Recipe>> apiCallback);

    public List<Recipe> filterByName(String name);

    public List<Recipe> filterByFavourite(Integer userID);

    public Recipe getRecipe(String name);

    public void addToFavourite(Integer recipeID);

    public void createRecipe(Recipe recipe);

    public void editRecipe(Recipe recipe);

    public void deleteRecipe(Integer recipeID);
}
