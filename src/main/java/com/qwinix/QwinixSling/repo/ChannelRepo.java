package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Channels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ChannelRepo extends JpaRepository<Channels, Long> {

    @Query("SELECT id FROM Channels where package_id = :package_id")
    public ArrayList<Long> findBySearchTerm(@Param("package_id") Long package_id);

}
