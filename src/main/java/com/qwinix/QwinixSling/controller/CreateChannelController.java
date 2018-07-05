package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.Channels;
import com.qwinix.QwinixSling.service.CreateChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateChannelController {
    @Autowired
    CreateChannelService createChannelService;

   // @PostMapping(name = "/channels/{id}")
    @PostMapping( "/channels/{id}")

    public String createChannel(@PathVariable Long id ,@RequestBody Channels channels){
        System.out.println("mathewwwwwwwwww");
        createChannelService.CreateChannel(id, channels);
        return "success";
    }
}
