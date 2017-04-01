package ru.datatex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.datatex.model.Users;
import ru.datatex.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return userService.getUsers();
    }
}
