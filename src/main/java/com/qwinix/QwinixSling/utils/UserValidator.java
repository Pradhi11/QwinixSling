package com.qwinix.QwinixSling.utils;

import com.qwinix.QwinixSling.model.User;
import com.qwinix.QwinixSling.model.UserResponce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public static final boolean validateEmail(String email){
        if(email.length()<=0){
//            message = "email is required";
            return false;
        }else {
//            System.out.print("2222222");
            String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(email);
//            message = "invalid email";
            return matcher.matches();
        }
    }

    public static final boolean validatePassword(String password){
        if(password.length()<=0){
//            message = "password is required";
            return false;
        }else {
            String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&]).{8,}";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(PASSWORD_REGEX);
            matcher = pattern.matcher(password);
//            message = "invalid password";
            return matcher.matches();
        }
    }

    public static final boolean validatePhone(String phone){
        if(phone.length()<=0){
//            message = "phone is required";
            return false;
        }else {
            String PASSWORD_REGEX = "^[0-9]{10}$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(PASSWORD_REGEX);
            matcher = pattern.matcher(phone);
//            message = "invalid phone number";
            return matcher.matches();
        }
    }

    public static final boolean validateName(String name){
        if(name.length()<=0){
//            message = "name is required";
            return false;
        }else {
            String PASSWORD_REGEX = "^[A-z]+$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(PASSWORD_REGEX);
            matcher = pattern.matcher(name);
//            message = "Only Alphabets are allowed";
            return matcher.matches();
        }
    }

    public static final boolean validateIncome(String income){
        if(income.length()<=0){
//            message = "name is required";
            return false;
        }else {
            String INCOM_REGEX = "^[0-9]+$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(INCOM_REGEX);
            matcher = pattern.matcher(income);
//            message = "Only Alphabets are allowed";
            return matcher.matches();
        }
    }

    public static final boolean validateDod(String dob){
//        System.out.print("right BOBBBBB"+dob);
        if(dob.length()<=0){
//            message = "date of birth is required";
            return false;
        }else {
            boolean checkDate = isValidFormat("MM/dd/yyyy", dob);
            System.out.print(checkDate+"check");
            if(checkDate){
                 return checkDate;
             }else {
//                 message = "invalid date";
                 return checkDate;
             }
        }
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
                return false;
            }
            else{
                Date date1 = new Date();
                    Calendar a = getCalendar(date);
                    Calendar b = getCalendar(date1);
                    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
                    if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
                        diff--;
                    }
                    System.out.println(diff);
                    if (diff > 18){
                        return true;
                    }
                    else
                        return false;


            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    private static Calendar getCalendar(Date date1) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date1);
        return cal;
    }
}


