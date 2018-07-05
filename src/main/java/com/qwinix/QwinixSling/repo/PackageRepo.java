package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepo extends JpaRepository<Packages, Long> {
}
