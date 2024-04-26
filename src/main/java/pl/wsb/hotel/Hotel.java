package pl.wsb.hotel;

import java.util.List;

public class Hotel {
    private String name;
    private List<Client> clients;
    private List<Room> rooms;
    private List<RoomReservation> reservations;
    private List<SpecialService> specialServices;

    public Hotel(String name) {
        this.name = name;
    }

    public Hotel(String name, List<SpecialService> specialServices, List<RoomReservation> reservations, List<Room> rooms, List<Client> clients) {
        this.name = name;
        this.specialServices = specialServices;
        this.reservations = reservations;
        this.rooms = rooms;
        this.clients = clients;
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
}