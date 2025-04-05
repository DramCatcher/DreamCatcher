package com.example.Backend.resources.repository;

import com.example.Backend.resources.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamRepository extends JpaRepository<Dream, Long> {
    // Custom Queries
}
