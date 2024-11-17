package ru.mirea.bakiev.recipe_app.presentation.viewModels;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.bakiev.data.api.RemoteDataSource;
import ru.mirea.bakiev.data.repository.RecipeRepositoryImpl;
import ru.mirea.bakiev.domain.ApiCallback;
import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.usecases.recipe.GetAllRecipesUseCase;

public class MainActivityViewModel extends ViewModel {
    private GetAllRecipesUseCase getAllRecipesUseCase;
    private RemoteDataSource remoteDataSource;
    private MutableLiveData<List<Recipe>> allRecipe = new MutableLiveData<>();
    private MediatorLiveData<List<Recipe>> recipeLiveData = new MediatorLiveData<>();
    private Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;
        remoteDataSource = new RemoteDataSource();
        RecipeRepositoryImpl recipeRepository = new RecipeRepositoryImpl(remoteDataSource);
        getAllRecipesUseCase = new GetAllRecipesUseCase(recipeRepository);
        recipeLiveData.addSource(allRecipe, this::getRecipeLiveData);
    }

    private void getRecipeLiveData(List<Recipe> recipe) {
        recipeLiveData.setValue(recipe);
    }

    public void getAllRecipe() {
        getAllRecipesUseCase.execute(new ApiCallback<List<Recipe>>() {
            @Override
            public void onSuccess(List<Recipe> result) {
                allRecipe.setValue(result);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MediatorLiveData<List<Recipe>> getRecipeLiveData() {
        return recipeLiveData;
    }
}
