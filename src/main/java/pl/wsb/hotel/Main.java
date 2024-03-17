package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11));
        System.out.println("Test getters for Client");
        System.out.println(client.getAge());
        System.out.println(client.getId());
        System.out.println(client.getBirthDate());
        System.out.println(client.getFirstName());
        System.out.println(client.getLastName());

        client.setId("123124");
        client.setBirthDate(LocalDate.of(2022, 2, 2));
        client.setFirstName("Tester");
        client.setLastName("Testowy");

        System.out.println("Test getters for Client after setters");
        System.out.println(client.getAge());
        System.out.println(client.getId());
        System.out.println(client.getBirthDate());
        System.out.println(client.getFirstName());
        System.out.println(client.getLastName());

        Room room = new Room("12312", "description", 223.45, 4, false);
        System.out.println("Test getters for Room");
        System.out.println(room.getArea());
        System.out.println(room.getFloor());
        System.out.println(room.getDescription());
        System.out.println(room.getId());

        room.setArea(333.333);
        room.setDescription("Example desc");
        room.setFloor(3);
        room.setHasKingSizeBed(true);


        System.out.println("Test getters for Room after setters");
        System.out.println(room.getArea());
        System.out.println(room.getFloor());
        System.out.println(room.getDescription());
        System.out.println(room.getId());



        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);
    }
}
