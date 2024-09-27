package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class AddRecipeToFavouriteUseCase {
    private RecipeRepository recipeRepository;

    public AddRecipeToFavouriteUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute() {
        return recipeRepository.addToFavourite();
    }
}
