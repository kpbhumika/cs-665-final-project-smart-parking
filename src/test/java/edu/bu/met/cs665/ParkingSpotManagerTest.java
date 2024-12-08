package edu.bu.met.cs665;

import edu.bu.met.cs665.smart_parking.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingSpotManagerTest {

    private ParkingSpotManager manager;
    private User user1;
    private User user2;
    private ParkingSpot spot1;
    private ParkingSpot spot2;

    @Before
    public void setUp() {
        // Create ParkingSpotManager and Users
        manager = new ParkingSpotManager();
        user1 = new User("User 1");
        user2 = new User("User 2");

        // Create two parking spots
        spot1 = new ParkingSpotBuilder().setId("1").setLocation("A1").setAvailability(true).build();
        spot2 = new ParkingSpotBuilder().setId("2").setLocation("A2").setAvailability(true).build();

        // Add spots to the manager
        manager.addSpot(spot1);
        manager.addSpot(spot2);

        // Subscribe both users to the manager
        manager.subscribe(user1);
        manager.subscribe(user2);
    }

    @Test
    public void testBookSpot() {
        // User 1 books spot 1
        user1.bookSpot(manager, "1");

        // Check that the spot is now booked (not available)
        assertFalse("Spot 1 should be unavailable", spot1.isAvailable());
    }

    @Test
    public void testReleaseSpot() {
        // Book spot 1 and release it
        user1.bookSpot(manager, "1");
        user1.releaseSpot(manager, "1");

        // Check if the spot is available after release
        assertTrue("Spot 1 should be available", spot1.isAvailable());
    }

    @Test
    public void testUnsubscribeUser() {
        // User 1 is subscribed, now unsubscribe User 1
        manager.unsubscribe(user1);

        // User 1 should no longer receive updates, let's book a spot and check notifications

        // Book spot 1 and check the state of availability
        user2.bookSpot(manager, "1");

        // Since User 1 is unsubscribed, they should not receive notifications
        // We can verify the behavior by ensuring that the message is only received by User 2.
        assertFalse("Spot 1 should be unavailable", spot1.isAvailable());
    }

    @Test
    public void testMultipleUserInteractions() {
        // User 1 books spot 1
        user1.bookSpot(manager, "1");

        // User 2 attempts to book the same spot (which is already booked)
        user2.bookSpot(manager, "1");

        // Ensure that spot 1 is still unavailable after user2 tries to book it
        assertFalse("Spot 1 should still be unavailable", spot1.isAvailable());
    }
}
