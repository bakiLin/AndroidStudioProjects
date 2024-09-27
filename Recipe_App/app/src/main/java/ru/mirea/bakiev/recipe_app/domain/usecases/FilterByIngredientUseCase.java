package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class FilterByIngredientUseCase {
    private RecipeRepository recipeRepository;

    public FilterByIngredientUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe[] execute() {
        return recipeRepository.filterByIngredient();
    }
}
