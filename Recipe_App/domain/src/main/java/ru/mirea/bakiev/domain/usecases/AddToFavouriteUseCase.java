package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class AddToFavouriteUseCase {
    private RecipeRepository recipeRepository;

    public AddToFavouriteUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute(Integer recipeID) {
        return recipeRepository.addToFavourite(recipeID);
    }
}
