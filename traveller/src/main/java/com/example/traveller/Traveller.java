package com.example.traveller;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Traveller {

    @Id
    int travellerId; // Changed from passengerId to travellerId
    String travellerName; // Updated from passengerName
    String startingPoint; // Corrected variable name casing
    String destination;
    String mobileNumber; // Changed to a more descriptive variable name

    public Traveller() { // Constructor
    }

    public Traveller(int travellerId, String travellerName, String startingPoint, String destination, String mobileNumber) { // Updated constructor parameters
        this.travellerId = travellerId; // Changed variable name
        this.travellerName = travellerName;
        this.startingPoint = startingPoint; // Corrected variable name
        this.destination = destination;
        this.mobileNumber = mobileNumber; // Changed variable name
    }

    // Getters and Setters
    public int getTravellerId() { // Changed method name
        return travellerId; // Updated variable name
    }

    public void setTravellerId(int travellerId) { // Changed parameter name
        this.travellerId = travellerId;
    }

    public String getTravellerName() { // Changed method name
        return travellerName;
    }

    public void setTravellerName(String travellerName) { // Changed parameter name
        this.travellerName = travellerName;
    }

    public String getStartingPoint() { // Corrected method name casing
        return startingPoint; // Updated variable name
    }

    public void setStartingPoint(String startingPoint) { // Corrected method name casing
        this.startingPoint = startingPoint; // Updated variable name
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMobileNumber() { // Changed method name to reflect new variable name
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) { // Adjusted parameter name
        this.mobileNumber = mobileNumber; // Changed variable name
    }
}