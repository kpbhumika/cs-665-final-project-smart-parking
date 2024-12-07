/**
 * File Name: ParkingSpotObserver.java
 * Description: Observer interface for getting updates on parking spot availability.
 */

package edu.bu.met.cs665.smart_parking;


import java.util.List;

public interface ParkingSpotObserver {
    void update(List<ParkingSpot> availableSpots);
}

