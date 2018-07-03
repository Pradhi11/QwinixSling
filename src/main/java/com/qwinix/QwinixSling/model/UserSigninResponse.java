package com.qwinix.QwinixSling.model;

import java.util.ArrayList;

public class UserSigninResponse {
    private User user;
    private boolean status;
    private String message;
    private ArrayList<Packages> mPackages;

    public ArrayList<Packages> getmPackages() {
        return mPackages;
    }

    public void setmPackages(ArrayList<Packages> mPackages) {
        this.mPackages = mPackages;
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
