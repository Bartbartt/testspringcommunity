package com.example.testspringcommunity.repository;


import com.example.testspringcommunity.model.Frog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrogRepository extends JpaRepository<Frog, Integer> {
}