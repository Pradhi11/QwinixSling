package com.qwinix.QwinixSling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ListUser {

    @RequestMapping("/listUsers")
    public String listUser(){
        return "list user";
    }
}
