package com.qwinix.QwinixSling.controller;

import com.qwinix.QwinixSling.model.Packages;
import com.qwinix.QwinixSling.service.CreatePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CreatePackageController {
    @Autowired
    CreatePackageService createPackageService;

   // @PostMapping(name = "/packages/{id}")
    @PostMapping( "/packages/{id}")

    public String createPackage(@PathVariable Long id ,@RequestBody Packages packages){
        System.out.println("mathewwwwwwwwww");
        createPackageService.CreatePackage(id, packages);
        return "success";
    }
}
