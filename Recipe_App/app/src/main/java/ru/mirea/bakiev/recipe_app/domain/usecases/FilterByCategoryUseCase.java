package ru.mirea.bakiev.recipe_app.domain.usecases;

import java.util.List;

import ru.mirea.bakiev.recipe_app.domain.models.Category;
import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class FilterByCategoryUseCase {
    private RecipeRepository recipeRepository;

    public FilterByCategoryUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> execute(Category category) {
        return recipeRepository.filterByCategory(category);
    }
}
