package ru.mirea.bakiev.domain.models;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String pass;
    private List<String> createdRecipes;
    private List<String> favouriteRecipes;

    public User(String name, String email, String pass, List<String> createdRecipes, List<String> favouriteRecipes) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.createdRecipes = createdRecipes;
        this.favouriteRecipes = favouriteRecipes;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public List<String> getCreatedRecipes() {
        return createdRecipes;
    }

    public List<String> getFavouriteRecipes() {
        return favouriteRecipes;
    }
}
