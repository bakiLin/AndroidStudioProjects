package ru.mirea.bakiev.data.repository;

import ru.mirea.bakiev.data.firebase.AuthCallbackAdapter;
import ru.mirea.bakiev.data.firebase.AuthController;
import ru.mirea.bakiev.domain.AuthCallback;
import ru.mirea.bakiev.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    private AuthController authController;

    public UserRepositoryImpl(AuthController authController) {
        this.authController = authController;
    }

    @Override
    public void signIn(String email, String pass, AuthCallback authCallback) {
        authController.signIn(email, pass, new AuthCallbackAdapter(authCallback));
    }

    @Override
    public void signUp(String name, String email, String pass, AuthCallback authCallback) {
        authController.signUp(name, email, pass, new AuthCallbackAdapter(authCallback));
    }

    @Override
    public void signOut() {
        authController.signOut();
    }

    @Override
    public void changeProfileInfo() {
        //Changing profile info
    }

    @Override
    public boolean isSigned() {
        return authController.isSigned();
    }
}
