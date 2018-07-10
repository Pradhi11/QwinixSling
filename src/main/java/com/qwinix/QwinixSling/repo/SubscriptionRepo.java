package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscriptions, Long> {
    @Query("SELECT DISTINCT package_id FROM Subscriptions where user_id = :user_id")
    public ArrayList<Long> findByPackages(@Param("user_id") Long user_id);

    @Query("SELECT channel_id FROM Subscriptions where package_id = :package_id")
    public ArrayList<Long> findBySearchTerm(@Param("package_id") Long package_id);

    @Query("SELECT count(*) FROM Subscriptions where user_id = :id")
    public Long findUser(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Subscriptions where package_id = :package_id AND user_id = :user_id")
    public int deleteUserPackages(@Param("package_id") Long package_id, @Param("user_id") Long user_id);

}
