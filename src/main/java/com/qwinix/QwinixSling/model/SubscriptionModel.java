package com.qwinix.QwinixSling.model;

public class SubscriptionModel {

    private Long user_id;
    private Long package_id;
    private Long[] channel_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Long package_id) {
        this.package_id = package_id;
    }

    public Long[] getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(Long[] channel_id) {
        this.channel_id = channel_id;
    }
}
