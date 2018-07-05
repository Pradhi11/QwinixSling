package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepo extends JpaRepository<Packages, Long> {
}
