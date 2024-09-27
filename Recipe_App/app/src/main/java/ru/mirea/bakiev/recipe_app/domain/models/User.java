package ru.mirea.bakiev.recipe_app.domain.models;

public class User {
    private int id;
    private String username;
    private String email;
    private String pass;

    public User(int id, String username, String email, String pass) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
    }

    public static User temp = new User(0, "Любитель Лазаньи",
            "lasagna@mail.ru", "12345678");
}
