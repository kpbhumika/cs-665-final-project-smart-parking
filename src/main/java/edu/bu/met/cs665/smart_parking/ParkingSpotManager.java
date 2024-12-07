/**
 * File Name: ParkingSpotManager.java
 * Description: Manages parking spots and notifies observers when spots change.
 */

package edu.bu.met.cs665.smart_parking;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotManager {
    private List<ParkingSpot> spots = new ArrayList<>();
    private List<ParkingSpotObserver> observers = new ArrayList<>();
    private Map<String, ParkingSpot> bookedSpots = new HashMap<>(); // Map to track booked spots by ID

    // Method to add a parking spot
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
        notifyObservers();  // Notify observers about the available spots
    }

    // Method to update the availability of a spot (either book or clear)
    public void updateSpotAvailability(String spotId, boolean isAvailable, String userId) {
        for (ParkingSpot spot : spots) {
            if (spot.getId().equals(spotId)) {
                if (isAvailable) {
                    // The user is clearing the spot, only allow if they booked it
                    if (bookedSpots.get(userId) == spot) {
                        spot.setAvailability(true);
                        bookedSpots.remove(userId); // Remove from the booked map
                        System.out.println("Spot " + spotId + " is now available.");
                    } else {
                        System.out.println("You can only clear the spot you've booked.");
                    }
                } else {
                    // Booking the spot
                    if (!bookedSpots.containsValue(spot)) {
                        spot.setAvailability(false);
                        bookedSpots.put(userId, spot);  // Mark the spot as booked by the user
                        System.out.println("Spot " + spotId + " has been booked.");
                    } else {
                        System.out.println("Spot " + spotId + " is already booked.");
                    }
                }
                break;
            }
        }
        notifyObservers();  // Notify observers after updating the spot
    }

    // Method to get all available spots
    public List<ParkingSpot> getAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                availableSpots.add(spot);  // Add available spots to the list
            }
        }
        return availableSpots;
    }

    // Method to add an observer
    public void addObserver(ParkingSpotObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(ParkingSpotObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers about the changes
    public void notifyObservers() {
        for (ParkingSpotObserver observer : observers) {
            observer.update(getAvailableSpots());
        }
    }
}

