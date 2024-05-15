package pl.wsb.hotel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PremiumClientTest {

    @Test
    public void testPremiumClientGetFullName() {
        PremiumClient premiumClient = new PremiumClient(
                "1",
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "123456789",
                "1234567890",
                PremiumAccountType.PREMIUM);

        assertEquals("[premium] Doe, John", premiumClient.getFullName());
    }

    @Test
    public void testPremiumClientSetPremiumAccountType() {
        PremiumClient premiumClient = new PremiumClient(
                "1",
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "123456789",
                "1234567890",
                PremiumAccountType.PREMIUM);

        assertEquals(PremiumAccountType.PREMIUM, premiumClient.getPremiumAccountType());

        premiumClient.setPremiumAccountType(PremiumAccountType.PREMIUM_PLUS);
        assertEquals(PremiumAccountType.PREMIUM_PLUS, premiumClient.getPremiumAccountType());
    }
}