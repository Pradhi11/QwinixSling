package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscriptions, Long> {
}
