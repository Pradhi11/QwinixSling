package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.Packages;
import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;
import com.qwinix.QwinixSling.model.UserSigninResponse;
import com.qwinix.QwinixSling.repo.ClassificationRepo;
import com.qwinix.QwinixSling.repo.PackageRepo;
import com.qwinix.QwinixSling.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserSignInController {
    @Autowired
    CreateUserService userService;

    @Autowired
    PackageRepo packageRepo;

   @GetMapping("/login/{email}/{password}/{classification_id}")
   public UserSigninResponse loginUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password, @PathVariable(value = "classification_id") Long classification_id){
       UserSigninResponse userSigninResponse = userService.validateUserSignin(email, password);
       ArrayList<Long> packages =  packageRepo.findBySearchTerm(classification_id);
       ArrayList<Packages> userPackages = new ArrayList<>();
       for (Long i: packages
            ) {
           Packages p = new Packages();
           userPackages.add(packageRepo.findById(i).get());
       }
       System.out.print("hi this is result"+userPackages);
       userSigninResponse.setPackages(userPackages);
       return userSigninResponse;
    }
}
