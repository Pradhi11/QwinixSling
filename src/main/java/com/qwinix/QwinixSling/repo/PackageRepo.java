package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PackageRepo extends JpaRepository<Packages, Long> {

//    @Query("select id from packages where classification_id = :classification_id")
//    Long fectPackages(@Param("classification_id") Long classification_id);

    @Query("SELECT id FROM Packages where classification_id = :classification_id")
    public ArrayList<Long> findBySearchTerm(@Param("classification_id") Long classification_id);


}
