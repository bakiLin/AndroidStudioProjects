package ru.mirea.bakiev.data.repository;

import java.util.Arrays;
import java.util.List;

import ru.mirea.bakiev.domain.models.Category;
import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    public List<Recipe> getAllRecipes() {
        return Arrays.asList(Recipe.getTestRecipe());
    }

    public List<Recipe> filterByCategory(List<Category> categories) {
        return Arrays.asList(Recipe.getTestRecipe());
    }

    public List<Recipe> filterByName(String name) {
        return Arrays.asList(Recipe.getTestRecipe());
    }

    public List<Recipe> filterByFavourite(Integer userID) {
        return Arrays.asList(Recipe.getTestRecipe());
    }

    public Recipe getRecipe(Integer recipeID) {
        return Recipe.getTestRecipe();
    }

    public void addToFavourite(Integer recipeID) {
        //Adding recipe to fav
    }

    public void createRecipe(Recipe recipe) {
        //Creating recipe
    }

    public void editRecipe(Recipe recipe) {
        //Editing recipe
    }

    public void deleteRecipe(Integer recipeID) {
        //Deleting recipe
    }
}
