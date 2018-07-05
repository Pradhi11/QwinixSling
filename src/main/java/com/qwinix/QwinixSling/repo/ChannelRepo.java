package com.qwinix.QwinixSling.repo;

import com.qwinix.QwinixSling.model.Channels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ChannelRepo extends JpaRepository<Channels, Long> {

//    @Query("select id from packages where classification_id = :classification_id")
//    Long fectPackages(@Param("classification_id") Long classification_id);

    @Query("SELECT id FROM Channels where classification_id = :classification_id")
    public ArrayList<Long> findBySearchTerm(@Param("classification_id") Long classification_id);


}
