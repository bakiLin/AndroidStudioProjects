package ru.mirea.bakiev.data.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeApi {
    @GET("/json/1")
    Call<RecipeResponse> getAllRecipes();
}
