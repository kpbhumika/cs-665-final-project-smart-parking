/**
 * File Name: ParkingSpotNotifier.java
 * Description: Notifier interface for giving updates on parking spot availability.
 */

package edu.bu.met.cs665.smart_parking;

public interface ParkingSpotNotifier {
    void subscribe(ParkingSpotObserver observer);
    void unsubscribe(ParkingSpotObserver observer);
    void notifyObservers(String message);
}
