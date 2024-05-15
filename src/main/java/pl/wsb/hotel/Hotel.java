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

public class Hotel implements HotelCapability {
    private String name;
    private List<Client> clients;
    private List<Room> rooms;
    private List<RoomReservation> reservations;
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

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        return "";
    }

    @Override
    public String getClientFullName(String clientId) {
        return "";
    }

    @Override
    public int getNumberOfUnderageClients() {
        return 0;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        return "";
    }

    @Override
    public double getRoomArea(String roomId) {
        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        return 0;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        return "";
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        return "";
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        return false;
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