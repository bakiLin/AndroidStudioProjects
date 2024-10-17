package ru.mirea.bakiev.domain.usecases.recipe;

import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class AddToFavouriteUseCase {
    private RecipeRepository recipeRepository;

    public AddToFavouriteUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void execute(Integer recipeID) {
        recipeRepository.addToFavourite(recipeID);
    }
}
