package com.qwinix.QwinixSling.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long subsrciption_id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Packages> packages = new ArrayList<>();

    @OneToOne

    public Long getSubsrciption_id() {
        return subsrciption_id;
    }

    public void setSubsrciption_id(Long subsrciption_id) {
        this.subsrciption_id = subsrciption_id;
    }

    public List<Packages> getPackages() {
        return packages;
    }

    public void setPackages(List<Packages> packages) {
        this.packages = packages;
    }
}
