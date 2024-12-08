/**
 * Name: BHUMIKA KUSUGOLLI PARAMESWARA
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2024
 * File Name: Main.java
 * Description: This class manages the interaction between the user and the parking spot system. It allows the user to view, book, and clear parking spots, using the observer design pattern to notify about the status of parking spots.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.smart_parking.*;


public class Main {
    public static void main(String[] args) {
        // Create the parking spot manager (subject)
        ParkingSpotManager manager = new ParkingSpotManager();

        // Create users (observers)
        User user1 = new User("User 1");
        User user2 = new User("User 2");

        // Attach users to the parking spot manager
        manager.subscribe(user1);
        manager.subscribe(user2);

        // Create parking spots using the Builder pattern and add them to the manager
        ParkingSpot spot1 = new ParkingSpotBuilder()
                .setId("1")
                .setLocation("A1")
                .setAvailability(true)
                .build();

        ParkingSpot spot2 = new ParkingSpotBuilder()
                .setId("2")
                .setLocation("A2")
                .setAvailability(true)
                .build();

        ParkingSpot spot3 = new ParkingSpotBuilder()
                .setId("3")
                .setLocation("B1")
                .setAvailability(true)
                .build();

        manager.addSpot(spot1);
        manager.addSpot(spot2);
        manager.addSpot(spot3);

        manager.getAvailableSpotsMessage();

        user1.bookSpot(manager, "1");

        user2.bookSpot(manager, "2");

        user1.releaseSpot(manager, "1");

        manager.getAvailableSpotsMessage();

        user1.releaseSpot(manager, "2");

        manager.getAvailableSpotsMessage();

        manager.unsubscribe(user2);

        manager.getAvailableSpotsMessage();
    }
}

