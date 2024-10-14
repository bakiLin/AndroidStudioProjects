package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.repository.UserRepository;

public class SignOutUseCase {
    private UserRepository userRepository;

    public SignOutUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.signOut();
    }
}
