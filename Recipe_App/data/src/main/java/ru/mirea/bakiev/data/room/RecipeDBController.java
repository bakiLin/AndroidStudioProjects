package ru.mirea.bakiev.data.room;

import ru.mirea.bakiev.data.room.models.Recipe;

public interface RecipeDBController {
    public void getRecipe();
    public void addRecipe(Recipe recipe);
    public void deleteRecipe(int id);
}
