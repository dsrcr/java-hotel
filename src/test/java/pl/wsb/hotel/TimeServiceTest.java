/*
package pl.wsb.hotel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class TimeServiceTest {

    @Test
    public void testOrderService() {
        TimeService timeService = new TimeService("Time Check Service");
        timeService.orderService();
    }

    @Test
    public void testServiceIsAvailableAtTime() {
        TimeService timeService = new TimeService("Time Check Service");
        LocalTime availableTime = LocalTime.parse("12:00");
        assertTrue(timeService.serviceIsAvailableAtTime(availableTime));
        LocalTime beforeAvailableTime = LocalTime.parse("07:00");
        assertFalse(timeService.serviceIsAvailableAtTime(beforeAvailableTime));
        LocalTime afterAvailableTime = LocalTime.parse("00:00");
        assertFalse(timeService.serviceIsAvailableAtTime(afterAvailableTime));
    }

    @Test
    public void testGetFamilyOfService() {
        TimeService timeService = new TimeService("Time Check Service");
        assertEquals("support", timeService.getFamilyOfService());
    }
}*/
