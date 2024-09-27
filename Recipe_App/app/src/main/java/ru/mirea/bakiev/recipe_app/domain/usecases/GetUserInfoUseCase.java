package ru.mirea.bakiev.recipe_app.domain.usecases;

import ru.mirea.bakiev.recipe_app.domain.models.User;
import ru.mirea.bakiev.recipe_app.domain.repository.UserRepository;

public class GetUserInfoUseCase {
    private UserRepository userRepository;

    public GetUserInfoUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute() {
        return userRepository.getUserInfo();
    }
}
