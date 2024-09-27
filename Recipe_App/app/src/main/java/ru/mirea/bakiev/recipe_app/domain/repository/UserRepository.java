package ru.mirea.bakiev.recipe_app.domain.repository;

import ru.mirea.bakiev.recipe_app.domain.models.User;

public interface UserRepository {
    public boolean logIn();

    public boolean logOut();

    public boolean register();

    public User getUserInfo();
}
