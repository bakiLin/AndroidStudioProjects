package ru.mirea.bakiev.domain.usecases.recipe;

import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class DeleteRecipeUseCase {
    private RecipeRepository recipeRepository;

    public DeleteRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void execute(Integer recipeID) {
        recipeRepository.deleteRecipe(recipeID);
    }
}
