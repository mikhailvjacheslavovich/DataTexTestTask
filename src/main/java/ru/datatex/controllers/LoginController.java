package ru.datatex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.datatex.model.UsersEntity;
import ru.datatex.service.LoginService;





@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/getLogin", method = RequestMethod.GET)
    public UsersEntity getLogin(@RequestParam(value = "email") String email,
                          @RequestParam(value = "password") String password) {
        return loginService.getLogin(email, password);
    }
}
