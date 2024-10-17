package ru.mirea.bakiev.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.mirea.bakiev.data.room.models.Recipe;

@Dao
public interface RecipeDAO {
    @Query("select * from recipe")
    public List<Recipe> getAllRecipes();

    @Query("select * from recipe where id==:id")
    public List<Recipe> getById(int id);

    @Insert
    public void addRecipe(Recipe recipe);

    @Update
    public void changeRecipe(Recipe recipe);

    @Query("delete from recipe where id==:id")
    public void deleteRecipe(int id);

    @Query("delete from recipe")
    public void clear();
}
