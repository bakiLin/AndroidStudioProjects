package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class GetFavouriteRecipeUseCase {
    private RecipeRepository recipeRepository;

    public GetFavouriteRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe[] execute() {
        return recipeRepository.getFavourites();
    }
}
