package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class DeleteRecipeUseCase {
    private RecipeRepository recipeRepository;

    public DeleteRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute() {
        return recipeRepository.deleteRecipe();
    }
}
