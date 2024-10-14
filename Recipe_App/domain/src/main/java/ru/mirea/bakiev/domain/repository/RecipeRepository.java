package ru.mirea.bakiev.domain.repository;

import java.util.List;

import ru.mirea.bakiev.domain.models.Category;
import ru.mirea.bakiev.domain.models.Recipe;

public interface RecipeRepository {
    public List<Recipe> getAllRecipes();

    public List<Recipe> filterByCategory(Category category);

    public List<Recipe> filterByName(String name);

    public List<Recipe> filterByFavourite(Integer userID);

    public Recipe getRecipe(Integer recipeID);

    public boolean addToFavourite(Integer recipeID);

    public boolean createRecipe(Recipe recipe);

    public boolean editRecipe(Recipe recipe);

    public boolean deleteRecipe(Integer recipeID);
}
