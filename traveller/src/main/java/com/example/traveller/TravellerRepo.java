package com.example.traveller;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepo extends JpaRepository<Traveller, Integer> { // Changed the class name and parameter type

    // Additional custom query methods can be added here
}