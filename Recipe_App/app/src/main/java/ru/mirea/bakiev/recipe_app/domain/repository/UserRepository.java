package ru.mirea.bakiev.recipe_app.domain.repository;

public interface UserRepository {
    public boolean signUp(String email, String pass);

    public boolean singIn(String email, String pass);

    public boolean signOut();
}
