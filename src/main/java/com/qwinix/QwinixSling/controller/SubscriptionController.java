package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.Subscriptions;
import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.service.CreateSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @Autowired
    CreateSubscriptionService createSubscription;

    @PostMapping("/subscription/{user_id}")

    public User createSubcription(@PathVariable Long user_id, @RequestBody Subscriptions subscriptions){

        User user =  createSubscription.saveSubscription(user_id, subscriptions);
        return user;
    }
}
