package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT id FROM User where email = :email and password = :password")
    int loginUser(@Param("email") String email,
                  @Param("password") String password);

}
