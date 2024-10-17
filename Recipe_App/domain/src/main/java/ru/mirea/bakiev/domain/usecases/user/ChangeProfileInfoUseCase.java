package ru.mirea.bakiev.domain.usecases.user;

import ru.mirea.bakiev.domain.repository.UserRepository;

public class ChangeProfileInfoUseCase {
    private UserRepository userRepository;

    public ChangeProfileInfoUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute() {
        userRepository.changeProfileInfo();
    }
}
