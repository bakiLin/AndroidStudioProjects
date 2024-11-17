package ru.mirea.bakiev.data.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeApi {
    @GET("/all_recipe")
    Call<List<Post>> getAllRecipes();
}
