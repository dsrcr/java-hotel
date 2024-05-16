package pl.wsb.hotel;

import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;
import pl.wsb.hotel.interfaces.HotelCapability;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Hotel implements HotelCapability {
    private String name;
    private List<Client> clients = List.of();
    private List<Room> rooms = List.of();
    private List<RoomReservation> reservations = List.of();
    private List<SpecialService> specialServices;

    public Hotel(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RoomReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<RoomReservation> reservations) {
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpecialService> getSpecialServices() {
        return specialServices;
    }

    public void addSpecialService(List<SpecialService> specialServices) {
        this.specialServices = specialServices;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        String id = generateUniqueId();
        Client newClient = new Client(id, firstName, lastName, birthDate);
        clients.add(newClient);
        return id;
    }

    @Override
    public String getClientFullName(String clientId) {
        Client client = clients.stream().filter(c -> c.getId().equals(clientId)).findFirst().orElse(null);
        if (client == null) {
            return "User not found!";
        }
        return client.getFullName();
    }

    @Override
    public int getNumberOfUnderageClients() {
        return (int) clients.stream().filter(c -> c.getAge() < 18).count();
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description,
                          int numberOfWindows, boolean hasAc, boolean hasTv) {
        Room room = new Room(description, area, floor, hasKingSizeBed, numberOfWindows, hasAc, hasTv);
        rooms.add(room);

        return room.getId();
    }

    @Override
    public double getRoomArea(String roomId) {
        Room room = rooms.stream().filter(r -> r.getId().equals(roomId)).findFirst().orElse(null);
        if (room == null)
            return 0.0;
        else
            return room.getArea();
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        return (int) rooms.stream().filter(r -> r.getFloor() == floor && r.isHasKingSizeBed()).count();
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        Client client = clients.stream().filter(c -> c.getId().equals(clientId)).findFirst().orElse(null);
        if (client == null) {
            throw new ClientNotFoundException("Client " + clientId + " not found!");
        }
        Room room = rooms.stream().filter(r -> r.getId().equals(roomId)).findFirst().orElse(null);
        if (room == null) {
            throw new RoomNotFoundException("Room " + roomId + " not found!");
        }
        if (isRoomReserved(roomId, date)) {
            throw new RoomReservedException(roomId, date);
        }

        RoomReservation newReservation = new RoomReservation(date, client, room, false);
        this.reservations.add(newReservation);
        return newReservation.getReservationId();
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        RoomReservation reservation = reservations.stream().filter(r -> r.getReservationId().equals(reservationId)).findFirst().orElse(null);
        if (reservation == null) {
            throw new ReservationNotFoundException("Reservation " + reservationId + " not found!");
        }
        reservation.setConfirmed(true);
        return reservationId;
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        Room room = rooms.stream().filter(r -> r.getId().equals(roomId)).findFirst().orElse(null);
        if (room == null) {
            throw new RoomNotFoundException("Room " + roomId + " not found!");
        }
        return this.reservations.stream().anyMatch(r -> r.getRoom().getId()
                .equals(roomId) && r.getDate().equals(date));
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        int count = 0;
        for (RoomReservation reservation : reservations)
            if (!reservation.isConfirmed() && reservation.getDate().equals(date))
                count++;
        return count;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {
        List<String> ids = new ArrayList<>();

        boolean exists = false;
        for (Client client : clients)
            if (client.getId().equals(clientId)) {
                exists = true;
                break;
            }

        if (!exists)
            throw new ClientNotFoundException("Klient o podanym id: " + clientId + " nie zostal odnaleziony.");

        for (RoomReservation reservation : reservations)
            if (reservation.getClient().getId().equals(clientId))
                ids.add(reservation.getRoom().getId());

        return ids;
    }
}
