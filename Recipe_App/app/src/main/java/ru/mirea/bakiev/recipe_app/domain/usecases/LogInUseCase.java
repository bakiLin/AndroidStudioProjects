package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class LogInUseCase {
    private UserRepository userRepository;

    public LogInUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.logIn();
    }
}
