package ru.datatex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.datatex.database.LoginDataProvider;
import ru.datatex.model.Users;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginDataProvider loginDataProvider;

    public Users getLogin(String email, String password) {
        List<Users> users = loginDataProvider.getAllUsers();

        for (Users us : users){
            String st = us.getEmail();
            String tt = us.getPassword();
            if (us.getEmail().equals(email) && us.getPassword().equals(password)){
                return us;
            }
        }
        return null;
    }
}
