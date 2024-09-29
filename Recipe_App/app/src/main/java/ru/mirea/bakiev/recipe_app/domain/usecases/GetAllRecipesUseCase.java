package ru.mirea.bakiev.recipe_app.domain.usecases;

import java.util.List;

import ru.mirea.bakiev.recipe_app.domain.models.Recipe;
import ru.mirea.bakiev.recipe_app.domain.repository.RecipeRepository;

public class GetAllRecipesUseCase {
    private RecipeRepository recipeRepository;

    public GetAllRecipesUseCase(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> execute() {
        return recipeRepository.getAllRecipes();
    }
}
