package com.iweb.backend.repository;

import com.iweb.backend.models.User;
import com.iweb.backend.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {

    @Query("Select w from Website w WHERE w.user.id = :user")
    List<Website> findAllByUser(@Param("user") Long user);

    @Query("SELECT w FROM Website w WHERE w.id = :id")
    Website findByI(@Param("id") Long id);
}
