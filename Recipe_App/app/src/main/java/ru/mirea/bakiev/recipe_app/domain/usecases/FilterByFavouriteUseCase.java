package ru.mirea.bakiev.recipe_app.domain.usecases;

import java.util.List;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class FilterByFavouriteUseCase {
    private RecipeRepository recipeRepository;

    public FilterByFavouriteUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> execute(Integer userID) {
        return recipeRepository.filterByFavourite(userID);
    }
}
