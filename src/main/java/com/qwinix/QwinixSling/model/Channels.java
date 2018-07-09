package com.qwinix.QwinixSling.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="channels")
public class Channels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long channel_id;
    private String name;
    private int amount;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="package_id", referencedColumnName="package_id")

    private Packages packages;

    public long getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(long channel_id) {
        this.channel_id = channel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }
}
