package ru.mirea.bakiev.recipe_app.data.repository;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private Recipe recipe;

    public RecipeRepositoryImpl(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return Recipe.temp;
    }

    public boolean createRecipe() {
        return true;
    }

    public boolean editRecipe() {
        return true;
    }

    public boolean deleteRecipe() {
        return true;
    }

    public boolean addToFavourite() {
        return true;
    }

    public Recipe[] getFavourites() {
        return new Recipe[] {Recipe.temp};
    }

    public Recipe[] filterByCategory() {
        return new Recipe[] {Recipe.temp};
    }

    public Recipe[] filterByIngredient() {
        return new Recipe[] {Recipe.temp};
    }

    public boolean leaveComment() {
        return true;
    }

    public String[] getComments() {
        return new String[] {"Получилось очень вкусно!!"};
    }
}
