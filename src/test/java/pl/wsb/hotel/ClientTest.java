package pl.wsb.hotel;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    public void testClientFields() {
        LocalDate birthDate = LocalDate.of(1999, 9, 11);
        Client client = new Client("123123", "Adam", "Smith", birthDate);

        assertEquals("123123", client.getId());
        assertEquals("Adam", client.getFirstName());
        assertEquals("Smith", client.getLastName());
        assertEquals(birthDate, client.getBirthDate());

        LocalDate newBirthDate = LocalDate.of(2020, 1, 1);
        client.setBirthDate(newBirthDate);

        assertEquals(newBirthDate, client.getBirthDate());
    }
}
