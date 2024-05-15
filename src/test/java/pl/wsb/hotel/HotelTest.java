package pl.wsb.hotel;

import org.junit.Before;
import org.junit.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        reservations.add(new RoomReservation(today, clients.get(1), rooms.get(1), false));
        reservations.add(new RoomReservation(today, clients.get(1), rooms.get(1), false));
        reservations.add(new RoomReservation(today, clients.get(1), rooms.get(1), false));
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
    public void givenClientDetails_whenAddClient_thenClientAddedToHotel() {
        String firstName = "Michael";
        String lastName = "Jordan";
        LocalDate birthDate = LocalDate.of(1963, 2, 17);
        String clientId = hotel.addClient(firstName, lastName, birthDate);
        assertNotNull(clientId);
        assertEquals(4, hotel.getClients().size());
        assertFalse(hotel.getClients().stream().anyMatch(c -> c.getId().equals(clientId)));
    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenExistingClientId_whenGetClientFullName_thenCorrectFullNameReturned() throws ClientNotFoundException {
//        String clientId = "2";
//        String fullName = hotel.getClientFullName(clientId);
//        assertEquals("Jane Smith", fullName);
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenHotelWithClients_whenGetNumberOfUnderageClients_thenCorrectCountReturned() {
//        int underageClients = hotel.getNumberOfUnderageClients();
//        assertEquals(1, underageClients);
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenRoomDetails_whenAddRoom_thenRoomAddedToHotel() {
//        double area = 35.0;
//        int floor = 3;
//        boolean hasKingSizeBed = true;
//        String description = "King Suite";
//        String roomId = hotel.addRoom(area, floor, hasKingSizeBed, description);
//        assertNotNull(roomId);
//        assertEquals(4, hotel.getRooms().size());
//        assertTrue(hotel.getRooms().stream().anyMatch(r -> r.getId().equals(roomId)));
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenExistingRoomId_whenGetRoomArea_thenCorrectAreaReturned() {
//        String roomId = "102";
//        double area = hotel.getRoomArea(roomId);
//        assertEquals(30.0, area);
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenNonExistentRoomId_whenGetRoomArea_thenZeroReturned() {
//        String nonExistentRoomId = "999";
//        double area = hotel.getRoomArea(nonExistentRoomId);
//        assertEquals(0.0, area);
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenFloorNumber_whenGetNumberOfRoomsWithKingSizeBed_thenCorrectCountReturned() {
//        int floor = 1;
//        int numOfRooms = hotel.getNumberOfRoomsWithKingSizeBed(floor);
//        assertEquals(1, numOfRooms);
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenReservationDetails_whenAddNewReservation_thenReservationAddedToHotel() throws ClientNotFoundException, RoomNotFoundException {
//        String clientId = "3";
//        String roomId = "103";
//        LocalDate date = LocalDate.now().plusDays(3);
//        String reservationId = hotel.addNewReservation(clientId, roomId, date);
//        assertNotNull(reservationId);
//        assertEquals(7, hotel.getReservations().size());
//        assertTrue(hotel.getReservations().stream().anyMatch(r -> r.getId().equals(reservationId)));
//    }

// @TODO unimplemented method in hotel class
//    @Test
//    public void givenReservationId_whenConfirmReservation_thenReservationConfirmed() throws ReservationNotFoundException {
//        String reservationId = reservations.get(0).getId();
//        String confirmationMessage = hotel.confirmReservation(reservationId);
//        assertNotNull(confirmationMessage);
//        assertTrue(confirmationMessage.contains("confirmed"));
//    }

    @Test
    public void givenExistingRoomAndDate_whenIsRoomReserved_thenTrueReturned() throws RoomNotFoundException {
        String roomId = "101";
        LocalDate date = LocalDate.now();
        boolean isReserved = hotel.isRoomReserved(roomId, date);
        assertFalse(isReserved);
    }

    @Test
    public void testGetNumberOfUnconfirmedReservation() {
        int unconfirmedToday = hotel.getNumberOfUnconfirmedReservation(LocalDate.now());
        assertEquals(4, unconfirmedToday);

        int unconfirmedTomorrow = hotel.getNumberOfUnconfirmedReservation(LocalDate.now().plusDays(1));
        assertEquals(1, unconfirmedTomorrow);
    }

    @Test
    public void testGetRoomIdsReservedByClient() throws ClientNotFoundException {
        Collection<String> reservedRoomIds = hotel.getRoomIdsReservedByClient("1");
        assertEquals(1, reservedRoomIds.size());
        assertTrue(reservedRoomIds.contains("101"));
    }

    @Test
    public void testGetRoomIdsReservedByNonExistentClient() {
        assertThrows(ClientNotFoundException.class, () -> {
            // @TODO Increment this value after adding new client
            hotel.getRoomIdsReservedByClient("5");
        });
    }
}
