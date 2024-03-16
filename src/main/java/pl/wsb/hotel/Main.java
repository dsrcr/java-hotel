package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("xd");
        Client client = new Client("123123", "Filip", "Wandzio", LocalDate.now());
        System.out.println(client.getFullName());

        Room room = new Room("12312", "description", 223.45, 4, false);
        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);
    }
}
