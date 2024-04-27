package com.example.traveller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TravellerController
{
    @Autowired
    private TravellerService ts; // Changed from PassengerService to TravellerService

    @PostMapping("/traveller")
    public ResponseEntity<Traveller> addTraveller(@RequestBody Traveller t) // Changed parameter type and variable name
    {
        Traveller newTraveller = ts.create(t); // Updated service and object variable
        return new ResponseEntity<>(newTraveller, HttpStatus.CREATED);
    }

    @GetMapping("/travellers") 
    public List<Traveller> fetchTravellerList() // Updated method name
    { 
        return ts.fetchTravellerList(); // Changed to call the correct method from service
    } 

    

    @PutMapping("/traveller/{travellerId}") // Updated the path variable name
    public ResponseEntity<Traveller> updateTraveller(@PathVariable("travellerId") int travellerId, @RequestBody Traveller updatedTraveller) // Adjusted method name and variables
    {
        if(ts.updateDetails(travellerId, updatedTraveller) == true) // Changed to refer to correct service
        {
            return new ResponseEntity<>(updatedTraveller, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/traveller/{travellerId}") // Updated the path variable name
    public ResponseEntity<Boolean> deleteTraveller(@PathVariable("travellerId") int travellerId) // Adjusted method name
    {
        if(ts.deleteTraveller(travellerId) == true) // Changed to refer to correct method
        {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}