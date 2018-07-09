package com.qwinix.QwinixSling.service;

import com.qwinix.QwinixSling.Exception.ResourceNotFoundException;
import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;
import com.qwinix.QwinixSling.model.UserSigninResponse;
import com.qwinix.QwinixSling.repo.UserRepo;
import com.qwinix.QwinixSling.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.time.Instant;
import java.util.UUID;

@Service
public class CreateUserService {

    @Autowired
    UserRepo userRepo;

    public UserResponce validateUser(User user){

        String message;
        boolean success;

        UserResponce userResponce = new UserResponce();
        System.out.print("in servic1e1111111");
        if(UserValidator.validateEmail(user.getEmail())){
            if(UserValidator.validatePassword(user.getPassword())){
                if(UserValidator.validatePhone(user.getPhoneNumber())){
                    if(UserValidator.validateName(user.getName())){
                        if(UserValidator.validateIncome(user.getAnnualIncome())){
//                                System.out.print("876786876876");
                            if(UserValidator.validateDod(user.getDateOfBirth())){
                                System.out.print("llllllll");
//                                    System.out.print(user);

                                String str = DatatypeConverter.printBase64Binary(user.getPassword().getBytes());
                              //  String encriptedPwd = hashPassword(user.getPassword());
                             //   System.out.println(encriptedPwd);
                                user.setPassword(str);
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

   /* private String hashPassword(String plainTextPassword){
        System.out.println(plainTextPassword);
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }*/
    public UserSigninResponse validateUserSignin(String email, String password){

        String message;
        boolean success;

        UserSigninResponse userResponce = new UserSigninResponse();
//        System.out.print("in servic1e1111111");
        if(UserValidator.validateEmail(email)){
            if(UserValidator.validatePassword(password)){

                String str = DatatypeConverter.printBase64Binary(password.getBytes());
                // System.out.println(str);

                long userId = userRepo.loginUser(email, str);
                User user1 = userRepo.findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("user","id",userId));


               // User createUser = userRepo.save(user);
                if(userId > 0){
                    success = true;
                    message = "logged in sucessfully!";
                    userResponce.setUser(user1);
                    userResponce.setMessage(message);
                    userResponce.setStatus(success);
                    return userResponce;
                }else {
                    return null;
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


