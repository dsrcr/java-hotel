package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11), "adamsmith@example.org", "+48123456789", "99091122359");

        Room room = new Room("12312", "description", 223.45, 4, false, 2, false, true);
        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);
        System.out.println("Client: " + reservation.getClient().getFullName());
        System.out.println("Age: " + reservation.getClient().getAge());
    }
}
