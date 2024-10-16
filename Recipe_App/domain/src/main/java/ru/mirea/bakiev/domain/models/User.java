package ru.mirea.bakiev.domain.models;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String pass;
    private List<Integer> createdRecipesID;
    private List<Integer> favouriteRecipesID;

    public User(int id, String username, String email, String pass,
                List<Integer> createdRecipes, List<Integer> favouriteRecipes) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.createdRecipesID = createdRecipes;
        this.favouriteRecipesID = favouriteRecipes;
    }
}
