/*
package pl.wsb.hotel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;


public class LuggageServiceTest {
    @Test
    public void testOrderService() {
        LuggageService luggageService = new LuggageService("Luggage Storage Service");
        luggageService.orderService();
    }

    @Test
    public void testServiceIsAvailableAtTime() {
        LuggageService luggageService = new LuggageService("Luggage Storage Service");

        LocalTime availableTime = LocalTime.parse("10:00");
        assertTrue(luggageService.serviceIsAvailableAtTime(availableTime));

        LocalTime beforeAvailableTime = LocalTime.parse("05:00");
        assertFalse(luggageService.serviceIsAvailableAtTime(beforeAvailableTime));

        LocalTime afterAvailableTime = LocalTime.parse("18:00");
        assertFalse(luggageService.serviceIsAvailableAtTime(afterAvailableTime));
    }

    @Test
    public void testGetFamilyOfService() {
        LuggageService luggageService = new LuggageService("Luggage Storage Service");
        assertEquals("accommodation", luggageService.getFamilyOfService());
    }

}

*/
