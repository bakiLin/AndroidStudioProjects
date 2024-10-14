package ru.mirea.bakiev.data.repository;

import ru.mirea.bakiev.domain.repository.UserRepository;

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

    public boolean changeProfileInfo() {
        return true;
    }
}
