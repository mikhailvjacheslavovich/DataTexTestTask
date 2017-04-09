package ru.datatex.database;


import ru.datatex.model.UsersEntity;

import java.util.List;

public interface LoginDataProvider {
    public List<UsersEntity> getAllUsers();
}
