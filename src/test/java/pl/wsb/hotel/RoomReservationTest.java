package pl.wsb.hotel;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomReservationTest {
    @Test
    public void testRoomReservationFields() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11));

        Room room = new Room("12312", "description", 223.45, 4, false, 2, false);

        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room, false);

        assertEquals(LocalDate.now(), reservation.getDate());
        assertEquals(client, reservation.getClient());
        assertEquals(room, reservation.getRoom());
        assertFalse(reservation.isConfirmed());

        reservation.setDate(LocalDate.now().plusDays(1));
        reservation.setConfirmed(true);

        assertEquals(LocalDate.now().plusDays(1), reservation.getDate());
        assertTrue(reservation.isConfirmed());
    }
}
