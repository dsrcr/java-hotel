package pl.wsb.hotel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PremiumAccountTypeTest {

    @Test
    public void testPremiumAccountTypeValues() {
        assertEquals(2, PremiumAccountType.values().length);
        assertEquals(PremiumAccountType.PREMIUM, PremiumAccountType.values()[0]);
        assertEquals(PremiumAccountType.PREMIUM_PLUS, PremiumAccountType.values()[1]);
    }

    @Test
    public void testPremiumAccountTypeToString() {
        assertEquals("PREMIUM", PremiumAccountType.PREMIUM.toString());
        assertEquals("PREMIUM_PLUS", PremiumAccountType.PREMIUM_PLUS.toString());
    }

    @Test
    public void testPremiumAccountTypeValueOf() {
        assertEquals("PREMIUM", PremiumAccountType.valueOf("PREMIUM").toString());
        assertEquals("PREMIUM_PLUS", PremiumAccountType.valueOf("PREMIUM_PLUS").toString());
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testInvalidPremiumAccountTypeValueOf() {
//        PremiumAccountType.valueOf("INVALID");
//    }
}