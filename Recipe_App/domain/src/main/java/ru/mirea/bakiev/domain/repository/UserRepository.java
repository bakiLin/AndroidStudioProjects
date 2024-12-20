package ru.mirea.bakiev.domain.repository;

import ru.mirea.bakiev.domain.AuthCallback;

public interface UserRepository {
    public void signIn(String email, String pass, AuthCallback authCallback);

    public void signUp(String name, String email, String pass, AuthCallback authCallback);

    public void signOut();

    public void changeProfileInfo();

    public boolean isSigned();
}
