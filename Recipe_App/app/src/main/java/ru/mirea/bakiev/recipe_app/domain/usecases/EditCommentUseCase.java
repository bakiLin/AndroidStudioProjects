package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class EditCommentUseCase {
    private RecipeRepository recipeRepository;

    public EditCommentUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
}
