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
//        System.out.print("in servic1e1111111");
            if(UserValidator.validateEmail(user.getEmail())){
                if(UserValidator.validatePassword(user.getPassword())){
                    if(UserValidator.validatePhone(user.getPhoneNumber())){
                        if(UserValidator.validateName(user.getName())){
                            if(UserValidator.validateIncome(user.getAnnualIncome())){
//                                System.out.print("876786876876");
                                if(UserValidator.validateDod(user.getDateOfBirth())){
                                    System.out.print("llllllll");
//                                    System.out.print(user);
                                    User createUser = userRepo.save(user);
                                   if(createUser != null){
                                       success = true;
                                       message = "signed up sucessfully!";
                                       userResponce.setUser(user);
                                       userResponce.setMessage(message);
                                       userResponce.setStatus(success);
                                       return userResponce;
                                   }else {
                                       return null;
                                   }
                                }else {
                                    success = false;
//                                    userResponce.setMessage(message);
                                    userResponce.setStatus(success);
                                    return userResponce;
                                }
                            }else {
                                success = false;
//                                userResponce.setMessage(message);
                                userResponce.setStatus(success);
                                return userResponce;
                            }
                        }else {
                            success = false;
//                            userResponce.setMessage(message);
                            userResponce.setStatus(success);
                            return userResponce;
                        }
                    }else {
                        success = false;
//                        userResponce.setMessage(message);
                        userResponce.setStatus(success);
                        return userResponce;
                    }
                }else {
                    success = false;
//                    userResponce.setMessage(message);
                    userResponce.setStatus(success);
                    return userResponce;
                }
            }else {
                success = false;
//                userResponce.setMessage(message);
                userResponce.setStatus(success);
                return userResponce;
            }
        }
    }


