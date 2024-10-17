package ru.mirea.bakiev.domain.usecases.user;

import ru.mirea.bakiev.domain.AuthCallback;
import ru.mirea.bakiev.domain.repository.UserRepository;

public class SignUpUseCase {
    private UserRepository userRepository;

    public SignUpUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String name, String email, String pass, AuthCallback authCallback) {
        userRepository.signUp(name, email, pass, authCallback);
    }
}
