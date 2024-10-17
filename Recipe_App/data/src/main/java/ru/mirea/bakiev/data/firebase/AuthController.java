package ru.mirea.bakiev.data.firebase;

import ru.mirea.bakiev.domain.AuthCallback;

public interface AuthController {
    public void signIn(String email, String pass, AuthCallback authCallback);

    public void signUp(String name, String email, String pass, AuthCallback authCallback);

    public void signOut();

    public boolean isSigned();
}
