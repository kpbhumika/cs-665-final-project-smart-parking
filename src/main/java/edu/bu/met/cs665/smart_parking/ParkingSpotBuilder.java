/**
 * File Name: ParkingSpotBuilder.java
 * Description: Builder class for creating ParkingSpot objects.
 */

package edu.bu.met.cs665.smart_parking;

public class ParkingSpotBuilder {
    private String id;
    private String location;
    private boolean isAvailable;

    // Constructor that takes parameters for id, location, and availability
    public ParkingSpotBuilder(String id, String location, boolean isAvailable) {
        this.id = id;
        this.location = location;
        this.isAvailable = true;
    }

    // Getters for fields
    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters if you want to modify any attributes later (optional)
//    public ParkingSpotBuilder setId(String id) {
//        this.id = id;
//        return this;
//    }
//
//    public ParkingSpotBuilder setLocation(String location) {
//        this.location = location;
//        return this;
//    }
//
//    public ParkingSpotBuilder setAvailability(boolean isAvailable) {
//        this.isAvailable = isAvailable;
//        return this;
//    }

    // Build method to create the final ParkingSpot object
    public ParkingSpot build() {
        return new ParkingSpot(this);
    }
}




