package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.Exception.ResourceNotFoundException;
import com.qwinix.QwinixSling.model.Packages;
import com.qwinix.QwinixSling.model.Channels;
import com.qwinix.QwinixSling.repo.PackageRepo;
import com.qwinix.QwinixSling.repo.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateChannelService {
    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    PackageRepo packageRepo;
    public String CreateChannel(Long id, Channels channels){
        Packages packages = packageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("package", "id", id));
        channels.setPackages(packages);
        channelRepo.save(channels);
        return "success";
    }
}
