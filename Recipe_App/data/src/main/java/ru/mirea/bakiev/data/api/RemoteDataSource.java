package ru.mirea.bakiev.data.api;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.bakiev.domain.ApiCallback;
import ru.mirea.bakiev.domain.models.Recipe;

public class RemoteDataSource {
    private static final String BASE_URL = "https://0vj7g.wiremockapi.cloud";
    private RecipeApi recipeApi;

    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recipeApi = retrofit.create(RecipeApi.class);
    }

    public void getAllRecipe(ApiCallback<List<Recipe>> apiCallback) {
        recipeApi.getAllRecipes().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    apiCallback.onSuccess(ChangeClass(response.body()));
                } else {
                    apiCallback.onFailure(new Exception("Error"));
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                apiCallback.onFailure((Exception) t);
            }
        });
    }

    private List<Recipe> ChangeClass(List<Post> response) {
        List<Recipe> recipeList = new ArrayList<>();

        for (Post r : response) {
            Recipe recipe = new Recipe();

            recipe.setName(r.getName());
            recipe.setDescription(r.getDescription());
            recipe.setAuthor(r.getAuthor());
            recipe.setImg(r.getImg());

            recipeList.add(recipe);
        }

        return recipeList;
    }
}
