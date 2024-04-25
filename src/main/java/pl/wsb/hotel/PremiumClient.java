package pl.wsb.hotel;

import java.time.LocalDate;

public class PremiumClient extends Client{
    private PremiumAccountType premiumAccountType;

    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String emailAddress, String phoneNumber, String pesel, PremiumAccountType premiumAccountType) {
        super(id, firstName, lastName, birthDate, emailAddress, phoneNumber, pesel);
        this.premiumAccountType = premiumAccountType;
    }

    @Override
    public String getFullName() {
        return "[premium] " + getLastName() + ", " + getFirstName();
    }

    public PremiumAccountType getPremiumAccountType() {
        return premiumAccountType;
    }

    public void setPremiumAccountType(PremiumAccountType premiumAccountType) {
        this.premiumAccountType = premiumAccountType;
    }
}

