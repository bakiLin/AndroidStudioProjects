package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.models.Recipe;
import ru.mirea.bakiev.domain.repository.RecipeRepository;

public class GetRecipeUseCase {
    private RecipeRepository recipeRepository;

    public GetRecipeUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe execute(Integer recipeID) {
        return recipeRepository.getRecipe(recipeID);
    }
}
