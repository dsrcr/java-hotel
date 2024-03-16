package pl.wsb.hotel;

import java.time.LocalDate;

/**
 *
 */
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Client(String id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
