package ru.mirea.bakiev.domain.usecases.user;

import ru.mirea.bakiev.domain.repository.UserRepository;

public class IsUserSignedUseCase {
    private UserRepository userRepository;

    public IsUserSignedUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.isSigned();
    }
}
