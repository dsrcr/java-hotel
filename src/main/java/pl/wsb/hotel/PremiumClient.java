package pl.wsb.hotel;

import java.time.LocalDate;

public class PremiumClient extends Client{
    private PremiumAccountType premium_account_type;

    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, boolean sex, String emailAddress, long phoneNumber, boolean premiumAccountType, PremiumAccountType premiumAccountType1) {
        super(id, firstName, lastName, birthDate, sex, emailAddress, phoneNumber);
        premium_account_type = premiumAccountType1;
    }

    public PremiumAccountType getPremium_account_type() {
        return premium_account_type;
    }

    public void setPremium_account_type(PremiumAccountType premium_account_type) {
        this.premium_account_type = premium_account_type;
    }
    @Override
    public String getFullName() {
        return getLastName() + ", " + getFirstName();
    }
}
