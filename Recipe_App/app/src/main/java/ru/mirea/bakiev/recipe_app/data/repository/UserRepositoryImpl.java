package ru.mirea.bakiev.recipe_app.data.repository;

import ru.mirea.bakiev.recipe_app.domain.models.User;
import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private User user;

    public UserRepositoryImpl(User user) {
        this.user = user;
    }

    public boolean logIn() {
        return true;
    }

    public boolean logOut() {
        return true;
    }

    public boolean register() {
        return true;
    }

    public User getUserInfo() {
        return User.temp;
    }
}
