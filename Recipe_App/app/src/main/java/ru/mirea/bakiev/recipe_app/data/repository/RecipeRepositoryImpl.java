package ru.mirea.bakiev.recipe_app.data.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.mirea.bakiev.recipe_app.domain.models.Category;
import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private List<Recipe> recipes = new ArrayList<>(
            List.of(
                    new Recipe(
                            0, "Лазанья",
                            "Вкусная штука",
                            "любитель лазаньи",
                            Arrays.asList(Category.Second_Course))
            )
    );

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public List<Recipe> filterByCategory(Category category) {
        return recipes;
    }

    public List<Recipe> filterByName(String name) {
        return recipes;
    }

    public List<Recipe> filterByFavourite(Integer userID) {
        return recipes;
    }

    public Recipe getRecipe(Integer recipeID) {
        return recipes.get(recipeID);
    }

    public boolean addToFavourite(Integer recipeID) {
        return true;
    }

    public boolean createRecipe(Recipe recipe) {
        return true;
    }

    public boolean editRecipe(Recipe recipe) {
        return true;
    }

    public boolean deleteRecipe(Integer recipeID) {
        return true;
    }
}
