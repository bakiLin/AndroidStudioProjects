package ru.mirea.bakiev.domain.usecases.user;

import ru.mirea.bakiev.domain.AuthCallback;
import ru.mirea.bakiev.domain.repository.UserRepository;

public class SignInUseCase {
    private UserRepository userRepository;

    public SignInUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String email, String pass, AuthCallback authCallback) {
        userRepository.signIn(email, pass, authCallback);
    }
}
