package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PackageRepo extends JpaRepository<Packages, Long> {

    @Query("SELECT name FROM Packages where package_id = :package_id")
    public String getNameById(@Param("package_id") Long package_id);
}
