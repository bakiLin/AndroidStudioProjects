package ru.mirea.bakiev.domain.usecases.recipe;

import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class EditRecipeUseCase {
    private RecipeRepository recipeRepository;

    public EditRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void execute(Recipe recipe) {
        recipeRepository.editRecipe(recipe);
    }
}
