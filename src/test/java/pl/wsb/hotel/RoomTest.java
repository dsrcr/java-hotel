package pl.wsb.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void testRoomFields() {
        Room room = new Room("description", 223.45, 4, false, 2, false, true);

        assertEquals("description", room.getDescription());
        assertEquals(223.45, room.getArea());
        assertEquals(4, room.getFloor());
        assertFalse(room.isHasAc());
        assertEquals(2, room.getNumberOfWindows());
        assertFalse(room.isHasKingSizeBed());

        room.setArea(333.333);
        room.setDescription("Example desc");
        room.setFloor(3);
        room.setHasKingSizeBed(true);
        room.setHasAc(true);
        room.setNumberOfWindows(5);

        assertEquals(333.333, room.getArea());
        assertEquals("Example desc", room.getDescription());
        assertEquals(3, room.getFloor());
        assertTrue(room.isHasKingSizeBed());
        assertTrue(room.isHasAc());
        assertEquals(5, room.getNumberOfWindows());
    }
}
