package com.qwinix.QwinixSling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignIn {

    @RequestMapping("/hello")
    public String sayHi(){
        return "hello";
    }
}
