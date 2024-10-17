package ru.mirea.bakiev.domain.usecases.recipe;

import java.util.List;

import ru.mirea.bakiev.domain.models.Category;
import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class FilterByCategoryUseCase {
    private RecipeRepository recipeRepository;

    public FilterByCategoryUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> execute(List<Category> categories) {
        return recipeRepository.filterByCategory(categories);
    }
}
