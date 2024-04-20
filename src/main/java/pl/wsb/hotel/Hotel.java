package pl.wsb.hotel;

import java.util.List;

public class Hotel {
    private String name;
    private List<Client> clients;
    private List<Room> rooms;
    private List<RoomReservation> reservations;
    private List<SpecialService> specialServices;

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
}
