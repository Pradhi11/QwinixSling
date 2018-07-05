package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.service.CreateSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @Autowired
    CreateSubscription createSubscription;

    @PostMapping("/subscription/{user_id}")

    public String createSubcription(@PathVariable Long user_id){

        String returnSub =  createSubscription.saveSubscription();
        return returnSub;
    }
}
