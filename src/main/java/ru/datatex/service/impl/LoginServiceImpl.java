package ru.datatex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.datatex.database.LoginDataProvider;
import ru.datatex.model.UsersEntity;
import ru.datatex.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDataProvider loginDataProvider;

    public UsersEntity getLogin(String email, String password) {
        List<UsersEntity> users = loginDataProvider.getAllUsers();
        for (UsersEntity us : users) {
            if (us.getEmail().equals(email) && us.getPassword().equals(password)) {
                return us;
            }
        }
        return null;
    }
}
