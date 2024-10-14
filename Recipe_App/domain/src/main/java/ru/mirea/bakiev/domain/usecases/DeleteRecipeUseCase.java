package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class DeleteRecipeUseCase {
    private RecipeRepository recipeRepository;

    public DeleteRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute(Integer recipeID) {
        return recipeRepository.deleteRecipe(recipeID);
    }
}
