/**
 * File Name: ParkingSpot.java
 * Description: Represents a parking spot with an ID, location, and availability status.
 */

package edu.bu.met.cs665.smart_parking;


public class ParkingSpot {
    private String id;
    private String location;
    private boolean isAvailable;

    public ParkingSpot(String id, String location, boolean isAvailable) {
        this.id = id;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
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



