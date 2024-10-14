package ru.mirea.bakiev.domain.usecases;

import java.util.List;

import ru.mirea.bakiev.domain.repository.RecipeRepository;
import ru.mirea.bakiev.domain.models.Recipe;

public class FilterByFavouriteUseCase {
    private RecipeRepository recipeRepository;

    public FilterByFavouriteUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> execute(Integer userID) {
        return recipeRepository.filterByFavourite(userID);
    }
}
