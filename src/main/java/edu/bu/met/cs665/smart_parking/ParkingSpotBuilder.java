/**
 * File Name: ParkingSpotBuilder.java
 * Description: Builder class for creating ParkingSpot objects.
 */

package edu.bu.met.cs665.smart_parking;

public class ParkingSpotBuilder {
    private String id;
    private String location;
    private boolean isAvailable;


    // Set the Spot ID
    public ParkingSpotBuilder setId(String id) {
        this.id = id;
        return this;
    }

    // Set the Spot Location
    public ParkingSpotBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    // Set the Spot Availability
    public ParkingSpotBuilder setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }

    // Method to build the ParkingSpot object
    public ParkingSpot build() {
        return new ParkingSpot(this.id, this.location, this.isAvailable);
    }
}
