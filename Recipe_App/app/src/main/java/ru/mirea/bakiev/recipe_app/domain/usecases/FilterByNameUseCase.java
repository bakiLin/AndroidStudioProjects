package ru.mirea.bakiev.recipe_app.domain.usecases;

import java.util.List;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class FilterByNameUseCase {
    private RecipeRepository recipeRepository;

    public FilterByNameUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> execute(String name) {
        return recipeRepository.filterByName(name);
    }
}
