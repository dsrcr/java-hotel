package pl.wsb.hotel;

import org.junit.Before;
import org.junit.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

public class HotelTest {

    private Hotel hotel;
    private List<Client> clients;
    private List<Room> rooms;
    private List<RoomReservation> reservations;


    @Before
    public void setUp() {
        hotel = new Hotel("Example hotel");
        clients = new ArrayList<>();
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        clients.add(new Client("1", "John", "Doe", LocalDate.of(1990, 5, 15), "john.doe@example.com", "123456789", "1234567890"));
        clients.add(new Client("2", "Jane", "Smith", LocalDate.of(1985, 10, 20), "jane.smith@example.com", "987654321", "0987654321"));
        clients.add(new Client("3", "Alice", "Johnson", LocalDate.of(1978, 3, 8), "alice.johnson@example.com", "456789123", "4561237890"));

        clients.add(new PremiumClient("4", "Bob", "Johnson", LocalDate.of(1980, 2, 28), "bob.johnson@example.com", "654321789", "789456123", PremiumAccountType.PREMIUM));

        rooms.add(new Room("101", "Standard Room", 25.0, 1, true, 2, true, true));
        rooms.add(new Room("102", "Deluxe Room", 30.0, 2, false, 1, true, true));
        rooms.add(new Room("103", "Suite", 50.0, 3, true, 3, true, true));

        LocalDate today = LocalDate.now();
        reservations.add(new RoomReservation(today, clients.get(0), rooms.get(0), true));
        reservations.add(new RoomReservation(today.plusDays(1), clients.get(1), rooms.get(1), false));
        reservations.add(new RoomReservation(today.plusDays(2), clients.get(2), rooms.get(2), true));

        hotel.setClients(clients);
        hotel.setRooms(rooms);
        hotel.setReservations(reservations);
    }

    @Test
    public void testAddRoom() {
        Room newRoom = new Room("104", "Executive Room", 40.0, 4, true, 2, true, true);
        hotel.getRooms().add(newRoom);
        assertTrue(hotel.getRooms().contains(newRoom));
    }

    @Test
    public void testRemoveRoom() {
        Room roomToRemove = rooms.get(0);
        hotel.getRooms().remove(roomToRemove);
        assertFalse(hotel.getRooms().contains(roomToRemove));
    }

    @Test
    public void testAddReservation() {
        RoomReservation newReservation = new RoomReservation(LocalDate.now(), clients.get(0), rooms.get(0), true);
        hotel.getReservations().add(newReservation);
        assertTrue(hotel.getReservations().contains(newReservation));
    }

    @Test
    public void testRemoveReservation() {
        RoomReservation reservationToRemove = reservations.get(0);
        hotel.getReservations().remove(reservationToRemove);
        assertFalse(hotel.getReservations().contains(reservationToRemove));
    }

    @Test
    public void addNewReservation() {
        try {
            hotel.addNewReservation("1", "102", LocalDate.now());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
        try {
            hotel.addNewReservation("2", "102", LocalDate.now());
        } catch (RoomReservedException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong exception thrown: " + e.getMessage());
        }
        try {
            hotel.addNewReservation("100", "103", LocalDate.now());
        } catch (ClientNotFoundException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong exception thrown: " + e.getMessage());
        }
        try {
            hotel.addNewReservation("1", "2030", LocalDate.now());
        } catch (RoomNotFoundException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void isRoomReserved() {
        try {
            assertTrue(hotel.isRoomReserved("101", LocalDate.now()));
            assertFalse(hotel.isRoomReserved("102", LocalDate.now()));
        } catch (RoomNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
        try {
            hotel.isRoomReserved("2030", LocalDate.now());
        } catch (RoomNotFoundException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong exception thrown: " + e.getMessage());
        }
    }
}