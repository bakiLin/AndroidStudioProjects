package ru.mirea.bakiev.data.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.bakiev.domain.models.Recipe;

public class RemoteDataSource {
    private static final String BASE_URL = "https://0vj7g.wiremockapi.cloud/";
    private RecipeApi recipeApi;

    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recipeApi = retrofit.create(RecipeApi.class);
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        MutableLiveData<List<Recipe>> recipeListLiveData = new MutableLiveData<>();

        recipeApi.getAllRecipes().enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    recipeListLiveData.setValue(response.body().getData());
                } else {
                    recipeListLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                recipeListLiveData.setValue(null);
            }
        });

        return recipeListLiveData;
    }
}
