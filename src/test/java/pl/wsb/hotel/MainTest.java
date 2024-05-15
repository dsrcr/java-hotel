package pl.wsb.hotel;

import org.junit.jupiter.api.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMain() throws ClientNotFoundException, RoomNotFoundException {
        // Create a client
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11),
                "adamsmith@example.org", "+48123456789", "99091122359");

        // Create a room
        Room room = new Room("12312", "description", 223.45, 4, false, 2, false, true);

        // Create a room reservation
        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);

        // Test client details
        assertEquals("Adam Smith", reservation.getClient().getFullName());
        assertEquals(24, reservation.getClient().getAge()); // Assuming current date is used

        // Test special services
        LuggageService x = new LuggageService("Walizki");
        LuggageService y = new LuggageService("Samochód");
        TimeService z = new TimeService("Czas");

        List<SpecialService> specialServices = new ArrayList<>();
        specialServices.add(x);
        specialServices.add(y);
        specialServices.add(z);

        for (SpecialService service : specialServices) {
            assertTrue(service.serviceIsAvailableAtTime(LocalTime.now()));
        }
    }
}
