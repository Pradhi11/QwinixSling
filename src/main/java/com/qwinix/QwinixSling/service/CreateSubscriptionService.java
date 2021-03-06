package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.Exception.ResourceNotFoundException;
import com.qwinix.QwinixSling.model.*;
import com.qwinix.QwinixSling.repo.ChannelRepo;
import com.qwinix.QwinixSling.repo.PackageRepo;
import com.qwinix.QwinixSling.repo.SubscriptionRepo;
import com.qwinix.QwinixSling.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreateSubscriptionService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PackageRepo packageRepo;

    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    SubscriptionRepo subscriptionRepo;

    public ArrayList<Subscriptions> saveSubscription(Long id, SubscriptionModel subscriptionModel){
        ArrayList<Subscriptions> subscriptionsArrayList = new ArrayList<>();
        User user =  userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user" , "id", id));
        Packages packages = packageRepo.findById(subscriptionModel.getPackage_id()).orElseThrow(()-> new ResourceNotFoundException("packages", "package_id", subscriptionModel.getPackage_id()));
        for (Long channel_id: subscriptionModel.getChannel_id()
             ) {
            Channels channels = new Channels();
            channels = channelRepo.findById(channel_id).orElseThrow(() -> new ResourceNotFoundException("channels" , "id", channel_id));
            Subscriptions subscriptions = new Subscriptions();
            subscriptions.setChannel_id(channels.getChannel_id());
            subscriptions.setPackage_id(packages.getPackage_id());
            subscriptions.setUser_id(user.getUser_id());
            subscriptionsArrayList.add(subscriptionRepo.save(subscriptions));
        }

        return subscriptionsArrayList;
    }
}
