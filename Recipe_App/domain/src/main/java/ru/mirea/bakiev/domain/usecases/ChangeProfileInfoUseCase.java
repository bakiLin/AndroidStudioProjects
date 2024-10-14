package ru.mirea.bakiev.domain.usecases;

import ru.mirea.bakiev.domain.repository.UserRepository;

public class ChangeProfileInfoUseCase {
    private UserRepository userRepository;

    public ChangeProfileInfoUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.changeProfileInfo();
    }
}
