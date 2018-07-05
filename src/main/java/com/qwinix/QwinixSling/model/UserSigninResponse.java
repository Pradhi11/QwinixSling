package com.qwinix.QwinixSling.model;

import java.util.ArrayList;

public class UserSigninResponse {
    private User user;
    private boolean status;
    private String message;
    private ArrayList<Packages> Packages;

    public ArrayList<Packages> getPackages() {
        return Packages;
    }

    public void setPackages(ArrayList<Packages> Packages) {
        this.Packages = Packages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
