package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.Exception.ResourceNotFoundException;
import com.qwinix.QwinixSling.model.Subscriptions;
import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSubscriptionService {

    @Autowired
    UserRepo userRepo;
    public User saveSubscription(Long id, Subscriptions subscriptions){
        User user =  userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user" , "id", id));
        return user;
    }
}
