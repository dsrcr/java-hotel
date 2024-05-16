package pl.wsb.hotel;

import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11), "adamsmith@example.org", "+48123456789", "99091122359");

        Room room = new Room("description", 223.45, 4, false, 2, false, true);
        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);
        System.out.println("Client: " + reservation.getClient().getFullName());
        System.out.println("Age: " + reservation.getClient().getAge());

        LuggageService x = new LuggageService("Walizki");
        LuggageService y = new LuggageService("Samochód");
        TimeService z = new TimeService("Czas");

        List<SpecialService> specialServices = new ArrayList<>();

        specialServices.add(x);
        specialServices.add(y);
        specialServices.add(z);

        for (SpecialService service : specialServices) {
            service.orderService();
            System.out.println("Service " + service.getName() + " available: " +
                    service.serviceIsAvailableAtTime(LocalTime.now()));
            System.out.println("Family of service: " + service.getFamilyOfService());
        }
    }
}
