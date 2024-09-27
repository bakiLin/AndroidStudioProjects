package ru.mirea.bakiev.recipe_app.domain.models;

public class Recipe {
    private int id;
    private String name;
    private String description;
    private String author;
    private Category[] categories;

    public Recipe(int id, String name, String description, String author, Category[] categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.categories = categories;
    }

    public static Recipe temp = new Recipe(0, "Лазанья",
            "Традиционное итальянское блюдо, представляющее собой пласты теста, переложенные различной начинкой.",
            "Любитель Лазаньи", new Category[] {Category.Second_Course});
}
