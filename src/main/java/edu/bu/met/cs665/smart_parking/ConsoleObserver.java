package edu.bu.met.cs665.smart_parking;

import java.util.List;

public class ConsoleObserver implements ParkingSpotObserver {
    @Override
    public void update(List<ParkingSpot> availableSpots) {
        System.out.println("Available Spots:");
        for (ParkingSpot spot : availableSpots) {
            System.out.println(spot);
        }
    }
}

