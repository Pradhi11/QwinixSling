package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;
import com.qwinix.QwinixSling.service.CreateUserService;
import com.qwinix.QwinixSling.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignUpController {

    @Autowired
    CreateUserService userService;

    @Autowired
    UserValidator userValidator;

    @PostMapping("/SingUp")
    public UserResponce creatUser(@RequestBody User user){

        UserResponce validUser = userValidator.validateUser(user);
        return validUser;
    }
}
