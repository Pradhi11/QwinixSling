package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Classifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepo extends JpaRepository<Classifications, Long> {
}
