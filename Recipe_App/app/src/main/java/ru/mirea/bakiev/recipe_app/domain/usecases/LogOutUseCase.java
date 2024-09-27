package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class LogOutUseCase {
    private UserRepository userRepository;

    public LogOutUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.logOut();
    }
}
