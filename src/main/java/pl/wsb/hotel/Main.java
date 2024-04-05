package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11));
        Room room = new Room("12312", "description", 223.45, 4, false, 2, false);
        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);
    }
}
