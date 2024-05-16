package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.time.LocalDate;

public class HotelTest {

    private static Hotel hotel;
    private static List<Client> clients;
    private static List<Room> rooms;
    private static List<RoomReservation> reservations;
    private static List<SpecialService> specialServices;

    @BeforeAll
    public static void setUp() {
        hotel = new Hotel("Example hotel");
        clients = new ArrayList<>();
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        specialServices = new ArrayList<>();

        clients.add(new Client("1", "John", "Doe", LocalDate.of(1990, 5, 15), "john.doe@example.com", "123456789", "1234567890"));
        clients.add(new Client("2", "Jane", "Smith", LocalDate.of(1985, 10, 20), "jane.smith@example.com", "987654321", "0987654321"));
        clients.add(new Client("3", "Alice", "Johnson", LocalDate.of(1978, 3, 8), "alice.johnson@example.com", "456789123", "4561237890"));
        clients.add(new Client("5", "Underage", "Client", LocalDate.now().minusYears(15), "underage.client@example.com", "123456789", "1234567890"));

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
    public void testGetName() {
        assertEquals("Example hotel", hotel.getName());
    }

    @Test
    public void testSetName() {
        String newName = "New Hotel Name";
        hotel.setName(newName);
        assertEquals(newName, hotel.getName());
    }

    @Test
    public void testGetSpecialServices() {
        assertNull(hotel.getSpecialServices());
    }

    @Test
    public void testAddSpecialService() {
        LuggageService x = new LuggageService("Walizki");
        LuggageService y = new LuggageService("Samochód");
        TimeService z = new TimeService("Czas");

        specialServices.add(x);
        specialServices.add(y);
        specialServices.add(z);

        hotel.addSpecialService(specialServices);
        assertNotNull(hotel.getSpecialServices());
        assertEquals(3, hotel.getSpecialServices().size());
    }

    @Test
    public void testAddClient() {
        String firstName = "John";
        String lastName = "Doe";
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        String clientId = hotel.addClient(firstName, lastName, birthDate);
        assertNotNull(clientId);

        Client addedClient = hotel.getClients().stream()
                .filter(client -> client.getId().equals(clientId))
                .findFirst()
                .orElse(null);
        assertNotNull(addedClient);
        assertEquals(firstName, addedClient.getFirstName());
        assertEquals(lastName, addedClient.getLastName());
        assertEquals(birthDate, addedClient.getBirthDate());
    }

    @Test
    public void testAddRoom() {
        Room newRoom = new Room("Executive Room", 40.0, 4, true, 2, true, true);
        hotel.getRooms().add(newRoom);
        assertTrue(hotel.getRooms().contains(newRoom));
    }

    @Test
    public void testRemoveRoom() {
        Room roomToRemove = rooms.get(1);
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
        RoomReservation reservationToRemove = reservations.get(1);
        hotel.getReservations().remove(reservationToRemove);
        assertFalse(hotel.getReservations().contains(reservationToRemove));
    }

    @Test
    public void testAddNewReservation() {
        try {
            hotel.addNewReservation(clients.get(1).getId(), rooms.get(1).getId(), LocalDate.now());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
        try {
            hotel.addNewReservation(clients.get(0).getId(), rooms.get(0).getId(), LocalDate.now());
        } catch (RoomReservedException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong exception thrown: " + e.getMessage());
        }
        try {
            hotel.addNewReservation("wrong_client_id", rooms.get(0).getId(), LocalDate.now());
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
    public void testIsRoomReserved() {
        try {
            assertTrue(hotel.isRoomReserved(rooms.get(0).getId(), LocalDate.now()));
            assertFalse(hotel.isRoomReserved(rooms.get(1).getId(), LocalDate.now()));
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

    @Test
    void testGetClientFullName() {
        Client client = clients.get(0);
        String fullName = hotel.getClientFullName(client.getId());
        assertEquals(hotel.getClientFullName(client.getId()), fullName);
    }

    @Test
    void testGetNumberOfUnderageClients() {
        int count = hotel.getNumberOfUnderageClients();
        assertEquals(1, count);
    }

    @Test
    void testConfirmReservation() {
        try {
            hotel.confirmReservation(reservations.get(0).getReservationId());
            assertTrue(reservations.get(0).isConfirmed());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
        try {
            hotel.confirmReservation("wrong_reservation_id");
        } catch (ReservationNotFoundException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetNumberOfUnconfirmedReservation() {
        int unconfirmedToday = hotel.getNumberOfUnconfirmedReservation(LocalDate.now());
        assertEquals(1, unconfirmedToday);

        int unconfirmedTomorrow = hotel.getNumberOfUnconfirmedReservation(LocalDate.now().plusDays(1));
        assertEquals(1, unconfirmedTomorrow);
    }

    @Test
    public void testGetRoomIdsReservedByClient() throws ClientNotFoundException {
        Collection<String> reservedRoomIds = hotel.getRoomIdsReservedByClient("1");
        assertEquals(1, reservedRoomIds.size());
        assertFalse(reservedRoomIds.contains("101"));
    }

    @Test
    public void testGetRoomIdsReservedByNonExistentClient() {
        assertThrows(ClientNotFoundException.class, () -> {
            // @TODO Increment this value after adding new client
            hotel.getRoomIdsReservedByClient("6");
        });
    }
}
