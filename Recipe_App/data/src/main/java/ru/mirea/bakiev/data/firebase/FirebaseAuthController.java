package ru.mirea.bakiev.data.firebase;

import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.bakiev.domain.AuthCallback;

public class FirebaseAuthController implements AuthController {
    private FirebaseAuth firebaseAuth;

    public FirebaseAuthController() {
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signIn(String email, String pass, AuthCallback authCallback) {
        firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnSuccessListener(result -> {
                    authCallback.onSuccess();
                })
                .addOnFailureListener(e -> {
                    authCallback.onFailure();
                });
    }

    @Override
    public void signUp(String name, String email, String pass, AuthCallback authCallback) {
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnSuccessListener(result -> {
                    authCallback.onSuccess();
                })
                .addOnFailureListener(e -> {
                    authCallback.onFailure();
                });
    }

    @Override
    public void signOut() {
        firebaseAuth.signOut();
    }

    @Override
    public boolean isSigned() {
        return firebaseAuth.getCurrentUser() != null;
    }
}
