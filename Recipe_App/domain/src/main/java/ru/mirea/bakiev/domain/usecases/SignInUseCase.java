package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.repository.UserRepository;

public class SignInUseCase {
    private UserRepository userRepository;

    public SignInUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(String email, String pass) {
        return userRepository.singIn(email, pass);
    }
}
