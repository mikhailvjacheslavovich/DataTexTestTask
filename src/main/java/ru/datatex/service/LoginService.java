package ru.datatex.service;

import ru.datatex.model.UsersEntity;

public interface LoginService {
    public UsersEntity getLogin(String email, String password);
}
