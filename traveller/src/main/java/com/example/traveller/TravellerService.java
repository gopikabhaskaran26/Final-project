package com.example.traveller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TravellerService {
   
    @Autowired
    TravellerRepo tr; // Updated variable name to reflect TravellerRepo

    // Post
    public Traveller create(Traveller t) { // Changed parameter and return types
        return tr.save(t); // Modified to save Traveller
    }

    // Get all travellers
    public List<Traveller> fetchTravellerList() { // Adjusted method name
        return (List<Traveller>) tr.findAll(); // Changed to fetch all Travellers
    } 

    // Get traveller by ID
    public Traveller getById(int travellerId) { // Updated method name and parameter
        return tr.findById(travellerId).orElse(null); // Corrected the repository call
    }

    // Get sorted travellers by a specific field
    public List<Traveller> getBySort(String field) { // Adjusted method name and variable
        return tr.findAll(Sort.by(Sort.Direction.ASC, field)); // Updated repository call
    }

    // Update traveller details
    public boolean updateDetails(int travellerId, Traveller t) { // Changed parameter names and type
        if (tr.findById(travellerId).isEmpty()) { // Corrected the check for existence
            return false;
        }
        try {
            tr.save(t); // Changed repository save call
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Delete traveller by ID
    public boolean deleteTraveller(int travellerId) { // Changed method and variable names
        if (this.getById(travellerId) == null) { // Updated to use the new method name
            return false;
        }
        tr.deleteById(travellerId); // Corrected the repository delete call
        return true;
    }

}