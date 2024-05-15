package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class HotelTest {

    private static Hotel hotel;
    private static List<Client> clients;
    private static List<Room> rooms;
    private static List<RoomReservation> reservations;


    @BeforeAll
    public static void setUp() {
        hotel = new Hotel("Example hotel");
        clients = new ArrayList<>();
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        clients.add(new Client("1", "John", "Doe", LocalDate.of(1990, 5, 15), "john.doe@example.com", "123456789", "1234567890"));
        clients.add(new Client("2", "Jane", "Smith", LocalDate.of(1985, 10, 20), "jane.smith@example.com", "987654321", "0987654321"));
        clients.add(new Client("3", "Alice", "Johnson", LocalDate.of(1978, 3, 8), "alice.johnson@example.com", "456789123", "4561237890"));

        clients.add(new PremiumClient("4", "Bob", "Johnson", LocalDate.of(1980, 2, 28), "bob.johnson@example.com", "654321789", "789456123", PremiumAccountType.PREMIUM));

        rooms.add(new Room("Standard Room", 25.0, 1, true, 2, true, true));
        rooms.add(new Room("Deluxe Room", 30.0, 2, false, 1, true, true));
        rooms.add(new Room("Suite", 50.0, 3, true, 3, true, true));
        rooms.add(new Room("Premium", 50.0, 3, true, 3, true, true));

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
        Room newRoom = new Room("Executive Room", 40.0, 4, true, 2, true, true);
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
    public void testGetRoomArea() {
        double area = hotel.getRoomArea(rooms.get(0).getId());
        assertEquals(25.0, area);
    }

    @Test
    public void testGetNumberOfRoomsWithKingSizeBed() {
        int count = hotel.getNumberOfRoomsWithKingSizeBed(3);
        assertEquals(2, count);
    }
}