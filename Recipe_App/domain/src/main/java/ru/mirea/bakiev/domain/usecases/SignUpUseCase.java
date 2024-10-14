package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.repository.UserRepository;

public class SignUpUseCase {
    private UserRepository userRepository;

    public SignUpUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(String email, String pass) {
        return userRepository.signUp(email, pass);
    }
}
