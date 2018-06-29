package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;
import com.qwinix.QwinixSling.repo.UserRepo;
import com.qwinix.QwinixSling.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    UserRepo userRepo;

    public UserResponce validateUser(User user){

        String message;
         boolean success;

         UserResponce userResponce = new UserResponce();
            if(UserValidator.validateEmail(user.getEmail())){
                if(UserValidator.validatePassword(user.getPassword())){
                    if(UserValidator.validatePhone(user.getPhoneNumber())){
                        if(UserValidator.validateName(user.getName())){
                            if(UserValidator.validateIncome(user.getAnnualIncome())){
                                if(UserValidator.validateDod(user.getDateOfBirth())){
                                    User createUser = userRepo.save(user);
                                   if(createUser != null){
                                       success = true;
                                       message = "signed up sucessfully!";
                                       userResponce.setUser(user);
                                       userResponce.setMessage(message);
                                       userResponce.setStatus(success);
                                       return userResponce;
                                   }else {
                                       success = false;
                                       message = "somthing went wrong!";
                                       userResponce.setUser(user);
                                       userResponce.setMessage(message);
                                       userResponce.setStatus(success);
                                       return userResponce;
                                   }
                                }else {
                                    success = false;
                                    message = "invalid annual income";
                                    userResponce.setMessage(message);
                                    userResponce.setStatus(success);
                                    return userResponce;
                                }
                            }else {
                                success = false;
                                message = "invalid name";
                                userResponce.setMessage(message);
                                userResponce.setStatus(success);
                                return userResponce;
                            }
                        }else {
                            success = false;
                            message = "invalid phone number";
                            userResponce.setMessage(message);
                            userResponce.setStatus(success);
                            return userResponce;
                        }
                    }else {
                        success = false;
                        message = "invalid password";
                        userResponce.setMessage(message);
                        userResponce.setStatus(success);
                        return userResponce;
                    }
                }else {
                    success = false;
                    message = "invalid password";
                    userResponce.setMessage(message);
                    userResponce.setStatus(success);
                    return userResponce;
                }
            }else {
                success = false;
                message = "email is required";
                userResponce.setMessage(message);
                userResponce.setStatus(success);
                return userResponce;
            }
        }
    }


