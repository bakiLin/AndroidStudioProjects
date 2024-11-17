package ru.mirea.bakiev.data.storage;

import ru.mirea.bakiev.domain.models.User;

public interface UserStorage {
    public User getUser();

    public void saveUser(User user);
}
