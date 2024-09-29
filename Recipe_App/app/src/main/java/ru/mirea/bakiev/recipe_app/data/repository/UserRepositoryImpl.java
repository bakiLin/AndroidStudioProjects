package ru.mirea.bakiev.recipe_app.data.repository;

import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    public boolean signUp(String email, String pass) {
        return true;
    }

    public boolean singIn(String email, String pass) {
        return true;
    }

    public boolean signOut() {
        return true;
    }
}
