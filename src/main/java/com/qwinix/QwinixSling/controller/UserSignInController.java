package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.Channels;
import com.qwinix.QwinixSling.model.PackageModel;
import com.qwinix.QwinixSling.model.UserSigninResponse;
import com.qwinix.QwinixSling.repo.ChannelRepo;
import com.qwinix.QwinixSling.repo.PackageRepo;
import com.qwinix.QwinixSling.repo.SubscriptionRepo;
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

    @Autowired
    SubscriptionRepo subscriptionRepo;
    @Autowired
    PackageRepo packageRepo;

   @GetMapping("/login/{email}/{password}/{user_id}")
   public UserSigninResponse loginUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password, @PathVariable(value = "user_id") Long user_id){
       UserSigninResponse userSigninResponse = userService.validateUserSignin(email, password);
       ArrayList<Long> packages = subscriptionRepo.findByPackages(user_id);
       ArrayList<PackageModel> userPackages = new ArrayList<>();
       for (Long j:packages
            ) {
           ArrayList<Long> channels =  subscriptionRepo.findBySearchTerm(j);
           String pname = packageRepo.getNameById(j);
            PackageModel packageModel= new PackageModel();
           ArrayList<Channels> userChannels = new ArrayList<>();
           for (Long i: channels
                   ) {
               Channels p = new Channels();

               userChannels.add(channelRepo.findById(i).get());
           }
           packageModel.setPackage_id(j);
           packageModel.setPackage_name(pname);
           packageModel.setChannels(userChannels);
           userPackages.add(packageModel);
       }

       System.out.print("hi this is result"+userPackages);
       userSigninResponse.setPackages(userPackages);
       return userSigninResponse;
    }
}
