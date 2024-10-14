package ru.mirea.bakiev.domain.repository;

public interface UserRepository {
    public boolean signUp(String email, String pass);

    public boolean singIn(String email, String pass);

    public boolean signOut();

    public boolean changeProfileInfo();
}
