package ru.mirea.bakiev.data.firebase;

import ru.mirea.bakiev.domain.AuthCallback;

public class AuthCallbackAdapter implements AuthCallback {
    private AuthCallback authCallback;

    public AuthCallbackAdapter(AuthCallback authCallback) {
        this.authCallback = authCallback;
    }

    @Override
    public void onSuccess() {
        authCallback.onSuccess();
    }

    @Override
    public void onFailure() {
        authCallback.onFailure();
    }
}
