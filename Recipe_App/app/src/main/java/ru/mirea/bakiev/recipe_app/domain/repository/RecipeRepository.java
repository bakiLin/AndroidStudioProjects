package ru.mirea.bakiev.recipe_app.domain.repository;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;

public interface RecipeRepository {
    public Recipe getRecipe();

    public boolean createRecipe();

    public boolean editRecipe();

    public boolean deleteRecipe();

    public boolean addToFavourite();

    public Recipe[] getFavourites();

    public Recipe[] filterByCategory();

    public Recipe[] filterByIngredient();

    public boolean leaveComment();

    public String[] getComments();
}
