package pl.wsb.hotel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

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

    @Test
    public void testSetLastName() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now(), "adamsmith@example.org", "+48123456789", "12345678901");
        client.setLastName("Brown");
        assertEquals("Brown", client.getLastName());
    }

    @Test
    public void testSetFirstName() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now(), "adamsmith@example.org", "+48123456789", "12345678901");
        client.setFirstName("John");
        assertEquals("John", client.getFirstName());
    }

    @Test
    public void testGetEmailAddress() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now(), "adamsmith@example.org", "+48123456789", "12345678901");
        assertEquals("adamsmith@example.org", client.getEmailAddress());
    }

    @Test
    public void testSetEmailAddress() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now(), "adamsmith@example.org", "+48123456789", "12345678901");
        client.setEmailAddress("johnbrown@example.org");
        assertEquals("johnbrown@example.org", client.getEmailAddress());
    }

    @Test
    public void testSetPhoneNumber() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now(), "adamsmith@example.org", "+48123456789", "12345678901");
        client.setPhoneNumber("+48123456700");
        assertEquals("+48123456700", client.getPhoneNumber());
    }

    @Test
    public void testSetPesel() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now(), "adamsmith@example.org", "+48123456789", "12345678901");
        client.setPesel("12345678902");
        assertEquals("12345678902", client.getPesel());
    }

    @Test
    void setBirthDate() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        LocalDate newBirthDate = LocalDate.now().minusYears(20);
        client.setBirthDate(newBirthDate);
        assertEquals(20, client.getAge());
    }

    @Test
    void setLastName() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        client.setLastName("Brown");
        assertEquals("Brown", client.getLastName());
    }

    @Test
    void setFirstName() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        client.setFirstName("John");
        assertEquals("John", client.getFirstName());
    }

    @Test
    void getEmailAddress() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        assertEquals("adam.smith@example.com", client.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        client.setEmailAddress("smith.adam@example.com");
        assertEquals("smith.adam@example.com", client.getEmailAddress());
    }

    @Test
    void getPhoneNumber() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        assertEquals("+48123456789", client.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        client.setPhoneNumber("+48123456700");
        assertEquals("+48123456700", client.getPhoneNumber());
    }

    @Test
    void getPesel() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        assertEquals("12345678901", client.getPesel());
    }

    @Test
    void setPesel() {
        Client client = new Client("123123", "Adam", "Smith", LocalDate.now().minusYears(18), "adam.smith@example.com", "+48123456789", "12345678901");
        client.setPesel("12345678902");
        assertEquals("12345678902", client.getPesel());
    }
}
