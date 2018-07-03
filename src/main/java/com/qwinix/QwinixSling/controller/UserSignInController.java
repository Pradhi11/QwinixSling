package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;
import com.qwinix.QwinixSling.model.UserSigninResponse;
import com.qwinix.QwinixSling.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.time.Instant;
import java.util.UUID;

@RestController
public class UserSignInController {
    @Autowired
    CreateUserService userService;

   // @GetMapping("/SignIn")
/*
    public User loginUser(@PathVariable(value = "userName") String userName, @PathVariable(value = "password") String password){
 */
   @GetMapping("/login/{email}/{password}")
   public UserSigninResponse loginUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password){


       UserSigninResponse userSigninResponse = userService.validateUserSignin(email, password);


       /* String str = DatatypeConverter.printBase64Binary(user.getPassword().getBytes());
        // System.out.println(str);

        long userId = user.loginUser(userName, str);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
        if( userId > 0){


            UUID uuid = UUID.randomUUID();
            Instant instant = Instant.now();
            Long timeStampSeconds = instant.getEpochSecond();
            userRepository.updateSession(userName, str, uuid.toString(), timeStampSeconds);
            user.setToken(uuid.toString());
        }*/
        return userSigninResponse;
    }
}
