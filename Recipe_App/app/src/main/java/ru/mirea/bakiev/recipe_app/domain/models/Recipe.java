package ru.mirea.bakiev.recipe_app.domain.models;

import java.util.List;

public class Recipe {
    private Integer id;
    private String name;
    private String description;
    private String author;
    private List<Category> categories;

    public Recipe(Integer id, String name, String description, String author, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}
