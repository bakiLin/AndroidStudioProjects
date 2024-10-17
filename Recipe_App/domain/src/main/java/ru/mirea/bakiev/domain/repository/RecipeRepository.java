package ru.mirea.bakiev.domain.repository;

import java.util.List;

import ru.mirea.bakiev.domain.models.Category;
import ru.mirea.bakiev.domain.models.Recipe;

public interface RecipeRepository {
    public List<Recipe> getAllRecipes();

    public List<Recipe> filterByCategory(List<Category> categories);

    public List<Recipe> filterByName(String name);

    public List<Recipe> filterByFavourite(Integer userID);

    public Recipe getRecipe(Integer recipeID);

    public void addToFavourite(Integer recipeID);

    public void createRecipe(Recipe recipe);

    public void editRecipe(Recipe recipe);

    public void deleteRecipe(Integer recipeID);
}
