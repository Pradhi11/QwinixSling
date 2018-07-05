package com.qwinix.QwinixSling.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "packages")
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long package_id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Channels> channels = new ArrayList<>();

    Packages(){}

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subsrciption_id", referencedColumnName="subsrciption_id")

    private Subscriptions subscriptions;

    public long getPackage_id() {
        return package_id;
    }

    public void setPackage_id(long package_id) {
        this.package_id = package_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Channels> getChannels() {
        return channels;
    }

    public void setChannels(List<Channels> channels) {
        this.channels = channels;
    }

    public Subscriptions getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }

    //    public Packages(List<Channels> channels) {
//        this.channels = channels;
//    }
}
