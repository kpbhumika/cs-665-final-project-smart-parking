/**
 * File Name: ParkingSpot.java
 * Description: Represents a parking spot with an ID, location, and availability status.
 */

package edu.bu.met.cs665.smart_parking;

public class ParkingSpot {
    private String id;
    private String location;
    private boolean isAvailable;

    // Constructor that takes a builder object
    public ParkingSpot(ParkingSpotBuilder builder) {
        this.id = builder.getId();
        this.location = builder.getLocation();
        this.isAvailable = builder.isAvailable();
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Spot ID: " + id + ", Location: " + location + ", Available: " + isAvailable;
    }
}
