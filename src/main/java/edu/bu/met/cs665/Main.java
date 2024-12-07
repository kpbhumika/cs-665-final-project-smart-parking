/**
 * Name: FIRST_NAME LAST_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: This class manages the interaction between the user and the parking spot system. It allows the user to view, book, and clear parking spots, using the observer design pattern to notify about the status of parking spots.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.smart_parking.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ParkingSpotManager parkingSpotManager = new ParkingSpotManager();

        ConsoleObserver consoleObserver = new ConsoleObserver();

        parkingSpotManager.addObserver(consoleObserver);

        ParkingSpot spot1 = new ParkingSpotBuilder("1", "A1", true).build();
        ParkingSpot spot2 = new ParkingSpotBuilder("2", "A2", true).build();
        ParkingSpot spot3 = new ParkingSpotBuilder("3", "B1", false).build();

        parkingSpotManager.addSpot(spot1);
        parkingSpotManager.addSpot(spot2);
        parkingSpotManager.addSpot(spot3);

        // Use Scanner to interact with the user
        Scanner scanner = new Scanner(System.in);
        String currentUserId = ""; // Will be set when booking/clearing spots.

        while (true) {
            // Display options to the user
            System.out.println("\nOptions:");
            System.out.println("1. View available spots");
            System.out.println("2. Book a spot");
            System.out.println("3. Clear a spot");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Notify observers to display available spots
                    parkingSpotManager.notifyObservers();
                    break;

                case 2:
                    // Book a parking spot
                    System.out.print("Enter Spot ID to book: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter your User ID: ");
                    currentUserId = scanner.nextLine();
                    parkingSpotManager.updateSpotAvailability(bookId, false, currentUserId);
                    break;

                case 3:
                    // Clear a parking spot
                    System.out.print("Enter Spot ID to clear: ");
                    String clearId = scanner.nextLine();
                    System.out.print("Enter your User ID: ");
                    currentUserId = scanner.nextLine();
                    parkingSpotManager.updateSpotAvailability(clearId, true, currentUserId);
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
