package com.qwinix.QwinixSling.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "classification")
public class Classifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classification_id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Packages> packages = new ArrayList<>();

    public long getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(long classification_id) {
        this.classification_id = classification_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Packages> getPackages() {
        return packages;
    }

    public void setPackages(List<Packages> packages) {
        this.packages = packages;
    }

    public Classifications(List<Packages> packages) {
        this.packages = packages;
    }
}
