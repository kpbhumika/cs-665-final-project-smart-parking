/**
 * File Name: User.java
 * Description: Represents a user who subscribes to the parking spot manager and receives notifications
 * about parking spot availability changes.
 */

package edu.bu.met.cs665.smart_parking;

public class User implements ParkingSpotObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }

    public void bookSpot(ParkingSpotManager manager, String spotId) {
        manager.bookSpot(spotId);
    }

    public void releaseSpot(ParkingSpotManager manager, String spotId) {
        manager.releaseSpot(spotId);
    }

}

