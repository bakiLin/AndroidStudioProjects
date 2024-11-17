package ru.mirea.bakiev.data.repository;

import java.util.Arrays;
import java.util.List;

import ru.mirea.bakiev.data.api.RemoteDataSource;
import ru.mirea.bakiev.domain.ApiCallback;
import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.models.User;
import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private User user;
    private RemoteDataSource remoteDataSource;

    public RecipeRepositoryImpl(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getAllRecipes(ApiCallback<List<Recipe>> apiCallback) {
        remoteDataSource.getAllRecipe(apiCallback);
    }

    public List<Recipe> filterByName(String name) {
        return Arrays.asList(new Recipe());
    }

    public List<Recipe> filterByFavourite(Integer userID) {
        return Arrays.asList(new Recipe());
    }

    public Recipe getRecipe(String name) {
        return new Recipe();
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
