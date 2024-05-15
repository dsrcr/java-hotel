package pl.wsb.hotel;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomReservationTest {
    @Test
    public void testRoomReservationFields() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.of(1999, 9, 11), "adamsmith@example.org", "+48123456789", "12345678901");

        Room room = new Room("description", 223.45, 4, false, 2, false, true);

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
