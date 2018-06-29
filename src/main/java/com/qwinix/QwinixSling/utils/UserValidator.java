package com.qwinix.QwinixSling.utils;

import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidator {

    public static String message;
    public static boolean success;
    public static final UserResponce validateUser(User user){

        UserResponce userResponce = new UserResponce();

        if(validateEmail(user.getEmail())){
            if(validatePassword(user.getPassword())){
                if(validatePhone(user.getPhoneNumber())){
                    if(validateName(user.getName())){
                        if(validateIncome(user.getAnnualIncome())){
                            if(validateDod(user.getDateOfBirth())){
                                success = true;
                                message = "signed up sucessfully!";
                                userResponce.setUser(user);
                                userResponce.setMessage(message);
                                userResponce.setStatus(success);
                                return userResponce;
                            }else {
                                success = false;
                                userResponce.setMessage(message);
                                userResponce.setStatus(success);
                                return userResponce;
                            }
                        }else {
                            success = false;
                            userResponce.setMessage(message);
                            userResponce.setStatus(success);
                            return userResponce;
                        }
                    }else {
                        success = false;
                        userResponce.setMessage(message);
                        userResponce.setStatus(success);
                        return userResponce;
                    }
                }else {
                    success = false;
                    userResponce.setMessage(message);
                    userResponce.setStatus(success);
                    return userResponce;
                }
            }else {
                success = false;
                userResponce.setMessage(message);
                userResponce.setStatus(success);
                return userResponce;
            }
        }else {
            success = false;
            userResponce.setMessage(message);
            userResponce.setStatus(success);
            return userResponce;
        }
    }

    public static final boolean validateEmail(String email){
        if(email.length()<=0){
            message = "email is required";
            return false;
        }else {
            String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(email);
            message = "invalid email";
            return matcher.matches();
        }
    }

    public static final boolean validatePassword(String password){
        if(password.length()<=0){
            message = "password is required";
            return false;
        }else {
            String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&]).{8,}";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(PASSWORD_REGEX);
            matcher = pattern.matcher(password);
            message = "invalid password";
            return matcher.matches();
        }
    }

    public static final boolean validatePhone(String phone){
        if(phone.length()<=0){
            message = "phone is required";
            return false;
        }else {
            String PASSWORD_REGEX = "^[0-9]{10}$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(PASSWORD_REGEX);
            matcher = pattern.matcher(phone);
            message = "invalid phone number";
            return matcher.matches();
        }
    }

    public static final boolean validateName(String name){
        if(name.length()<=0){
            message = "name is required";
            return false;
        }else {
            String PASSWORD_REGEX = "^[A-z]+$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(PASSWORD_REGEX);
            matcher = pattern.matcher(name);
            message = "Only Alphabets are allowed";
            return matcher.matches();
        }
    }

    public static final boolean validateIncome(String income){
        return true;
    }

    public static final boolean validateDod(String dob){
        return true;
    }
}

