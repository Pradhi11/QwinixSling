package com.qwinix.QwinixSling.model;

import java.util.ArrayList;

public class PackageModel {
    private Long package_id;
    private String package_name;
    private ArrayList<Channels> channels;

    public Long getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Long package_id) {
        this.package_id = package_id;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public ArrayList<Channels> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channels> channels) {
        this.channels = channels;
    }
}
