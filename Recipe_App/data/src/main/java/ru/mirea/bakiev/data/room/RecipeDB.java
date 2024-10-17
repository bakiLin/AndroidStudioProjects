package ru.mirea.bakiev.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.bakiev.data.room.models.Recipe;

@Database(entities = {Recipe.class}, version = 1)
public abstract class RecipeDB extends RoomDatabase {
    public abstract RecipeDAO getRecipeDAO();
}
