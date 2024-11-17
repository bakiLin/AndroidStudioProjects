package ru.mirea.bakiev.domain.usecases.recipe;

import java.util.List;

import ru.mirea.bakiev.domain.ApiCallback;
import ru.mirea.bakiev.domain.repository.RecipeRepository;
import ru.mirea.bakiev.domain.models.Recipe;

public class GetAllRecipesUseCase {
    private RecipeRepository recipeRepository;

    public GetAllRecipesUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void execute(ApiCallback<List<Recipe>> apiCallback) {
        recipeRepository.getAllRecipes(apiCallback);
    }
}
