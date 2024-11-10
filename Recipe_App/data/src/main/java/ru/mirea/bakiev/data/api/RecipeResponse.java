package ru.mirea.bakiev.data.api;

import java.util.List;

import ru.mirea.bakiev.domain.models.Recipe;

public class RecipeResponse {
    private List<Recipe> data;

    public List<Recipe> getData() {
        return data;
    }

    public void setData(List<Recipe> data) {
        this.data = data;
    }
}
