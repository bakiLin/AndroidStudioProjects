package ru.mirea.bakiev.domain.models;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private String description;
    private String author;
    private List<Category> categories;

    public Recipe(int id, String name, String description, String author, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.categories = categories;
    }

    public static Recipe getTestRecipe() {
        return new Recipe(0, "Лазанья", "Очень вкусно", "Какой-то итальянец",
                Arrays.asList(Category.Second_Course));
    }
}
