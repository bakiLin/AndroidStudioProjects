package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class SignOutUseCase {
    private UserRepository userRepository;

    public SignOutUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.signOut();
    }
}
