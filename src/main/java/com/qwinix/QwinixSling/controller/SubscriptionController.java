package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.SubscriptionModel;
import com.qwinix.QwinixSling.model.Subscriptions;
import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.service.CreateSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SubscriptionController {

    @Autowired
    CreateSubscriptionService createSubscription;

    @PostMapping("/subscription/{user_id}")
    public ArrayList<Subscriptions> createSubcription(@PathVariable Long user_id, @RequestBody SubscriptionModel subscriptionModel){
        ArrayList<Subscriptions> subscriptions =  createSubscription.saveSubscription(user_id, subscriptionModel);
        return subscriptions;
    }

    @PutMapping("/update_subscription/{user_id}")
    public String updateSubscriptions(@PathVariable Long user_id, @RequestBody SubscriptionModel subscriptionModel){
        ArrayList<Subscriptions> subscriptions =  createSubscription.updateSubscription(user_id, subscriptionModel);
        return "string";
    }

}
