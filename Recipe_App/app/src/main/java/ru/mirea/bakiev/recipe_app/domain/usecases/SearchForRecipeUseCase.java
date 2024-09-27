package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class SearchForRecipeUseCase {
    private RecipeRepository recipeRepository;

    public SearchForRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
}
