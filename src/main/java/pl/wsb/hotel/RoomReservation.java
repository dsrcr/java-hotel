package pl.wsb.hotel;

import java.time.LocalDate;
import java.util.UUID;

public class RoomReservation {
    private LocalDate date;
    private Client client;
    private Room room;
    private boolean isConfirmed;
    private String reservationId;

    public RoomReservation(LocalDate date, Client client, Room room, boolean isConfirmed) {
        this.date = date;
        this.client = client;
        this.room = room;
        this.isConfirmed = false;
        this.reservationId = generateReservationId();
    }

    private String generateReservationId() {
        return UUID.randomUUID().toString();
    }

    public String getReservationId() {
        return reservationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    private void confirmReservation() {
        this.isConfirmed = true;
    }
}
