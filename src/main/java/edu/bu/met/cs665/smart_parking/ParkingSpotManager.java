/**
 * File Name: ParkingSpotManager.java
 * Description: Manages parking spots and notifies observers when spots change.
 */

package edu.bu.met.cs665.smart_parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager implements ParkingSpotNotifier {
    private List<ParkingSpotObserver> observers = new ArrayList<>();
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    @Override
    public void subscribe(ParkingSpotObserver observer) {
        observers.add(observer);
        System.out.println(((User) observer).getName() + " has subscribed.");
    }

    @Override
    public void unsubscribe(ParkingSpotObserver observer) {
        observers.remove(observer);
        System.out.println(((User) observer).getName() + " has unsubscribed.");
    }

    @Override
    public void notifyObservers(String message) {
        for (ParkingSpotObserver observer : observers) {
            observer.update(message);
        }
    }

    public void addSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
        notifyObservers(getAvailableSpotsMessage());
    }

    public void bookSpot(String spotId) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getId().equals(spotId) && spot.isAvailable()) {
                spot.setAvailability(false);
                System.out.println("Spot " + spotId + " has been booked.");
                notifyObservers(getAvailableSpotsMessage());
                return;
            }
        }
        System.out.println("Spot " + spotId + " is already booked or does not exist.");
    }

    public void releaseSpot(String spotId) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getId().equals(spotId) && !spot.isAvailable()) {
                spot.setAvailability(true);
                System.out.println("Spot " + spotId + " has been released and is now available.");
                notifyObservers(getAvailableSpotsMessage());
                return;
            }
        }
        System.out.println("Spot " + spotId + " is already available or does not exist.");
    }

    public String getAvailableSpotsMessage() {
        StringBuilder message = new StringBuilder("Available spots:\n");
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                message.append(spot.toString()).append("\n");
            }
        }
        return message.toString();
    }
}


