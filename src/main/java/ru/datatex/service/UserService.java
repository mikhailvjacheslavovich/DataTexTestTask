package ru.datatex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.datatex.database.DataDao;
import ru.datatex.model.Users;

import java.util.List;

@Service
public class UserService {

    @Autowired
    DataDao dataDao;

    public List<Users> getUsers(){
        return dataDao.getAllUsers();
    }
}
