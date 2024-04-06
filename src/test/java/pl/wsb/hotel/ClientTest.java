package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    @Test
    public void testClientFields() {
        LocalDate birthDate = LocalDate.now();

        Client client = new Client("123123", "Adam", "Smith", birthDate, "adamsmith@example.org", "+48123456789", "12345678901");

        assertEquals("123123", client.getId());
        assertEquals("Adam", client.getFirstName());
        assertEquals("Smith", client.getLastName());
        assertEquals("Adam Smith", client.getFullName());
        assertEquals(0, client.getAge());
        assertEquals(birthDate, client.getBirthDate());

        LocalDate newBirthDate = birthDate.minusYears(5);
        client.setBirthDate(newBirthDate);

        assertEquals(5, client.getAge());

        assertEquals("+48123456789", client.getPhoneNumber());
        assertEquals("12345678901", client.getPesel());

    }
}
