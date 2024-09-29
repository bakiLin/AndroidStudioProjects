package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class AddToFavouriteUseCase {
    private RecipeRepository recipeRepository;

    public AddToFavouriteUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute(Integer recipeID) {
        return recipeRepository.addToFavourite(recipeID);
    }
}
