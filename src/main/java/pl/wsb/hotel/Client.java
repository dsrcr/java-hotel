package pl.wsb.hotel;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean sex;
    private String emailAddress;
    private long phoneNumber;

    public Client(String id, String firstName, String lastName, LocalDate birthDate, boolean sex, String emailAddress, long phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
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

    public int getAge() {
        Period period = Period.between(this.birthDate, LocalDate.now());
        int[] age = {period.getYears(), period.getMonths(), period.getDays()};
        return age[0];
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
