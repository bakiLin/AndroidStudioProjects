package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class CreateRecipeUseCase {
    private RecipeRepository recipeRepository;

    public CreateRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute(Recipe recipe) {
        return recipeRepository.createRecipe(recipe);
    }
}
