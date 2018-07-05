package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.model.Classifications;
import com.qwinix.QwinixSling.model.Packages;
import com.qwinix.QwinixSling.repo.ClassificationRepo;
import com.qwinix.QwinixSling.repo.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePackageService {
    @Autowired
    PackageRepo packageRepo;

    @Autowired
    ClassificationRepo classificationRepo;
    public String CreatePackage(Long id, Packages packages){
        System.out.println("iiiiiiiiii "+id);
        Optional<Classifications> classifications = classificationRepo.findById(id);
        if (classifications.isPresent()) {
            System.out.println("iiiiiiiiii "+classifications.get().getName());

            Classifications classifications1 = classifications.get();
            packages.setClassifications(classifications1);
            packageRepo.save(packages);
        }
        return "success";
    }
}
