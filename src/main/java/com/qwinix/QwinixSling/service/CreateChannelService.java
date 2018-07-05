package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.model.Classifications;
import com.qwinix.QwinixSling.model.Channels;
import com.qwinix.QwinixSling.repo.ClassificationRepo;
import com.qwinix.QwinixSling.repo.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateChannelService {
    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    ClassificationRepo classificationRepo;
    public String CreateChannel(Long id, Channels channels){
        Optional<Classifications> classifications = classificationRepo.findById(id);
        if (classifications.isPresent()) {
            Classifications classifications1 = classifications.get();
            channels.setClassifications(classifications1);
            channelRepo.save(channels);
        }
        return "success";
    }
}
