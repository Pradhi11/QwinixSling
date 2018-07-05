package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.Channels;
import com.qwinix.QwinixSling.model.UserSigninResponse;
import com.qwinix.QwinixSling.repo.ChannelRepo;
import com.qwinix.QwinixSling.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserSignInController {
    @Autowired
    CreateUserService userService;

    @Autowired
    ChannelRepo channelRepo;

   @GetMapping("/login/{email}/{password}/{classification_id}")
   public UserSigninResponse loginUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password, @PathVariable(value = "classification_id") Long classification_id){
       UserSigninResponse userSigninResponse = userService.validateUserSignin(email, password);
       ArrayList<Long> packages =  channelRepo.findBySearchTerm(classification_id);
       ArrayList<Channels> userPackages = new ArrayList<>();
       for (Long i: packages
            ) {
           Channels p = new Channels();
           userPackages.add(channelRepo.findById(i).get());
       }
       System.out.print("hi this is result"+userPackages);
       userSigninResponse.setChannels(userPackages);
       return userSigninResponse;
    }
}
