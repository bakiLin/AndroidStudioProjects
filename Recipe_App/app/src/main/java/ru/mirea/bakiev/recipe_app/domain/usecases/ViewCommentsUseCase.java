package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class ViewCommentsUseCase {
    private RecipeRepository recipeRepository;

    public ViewCommentsUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public String[] execute() {
        return recipeRepository.getComments();
    }
}
