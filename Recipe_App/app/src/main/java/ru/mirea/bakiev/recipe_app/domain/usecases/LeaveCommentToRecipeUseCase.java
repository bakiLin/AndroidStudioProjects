package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class LeaveCommentToRecipeUseCase {
    private RecipeRepository recipeRepository;

    public LeaveCommentToRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public boolean execute() {
        return recipeRepository.leaveComment();
    }
}
