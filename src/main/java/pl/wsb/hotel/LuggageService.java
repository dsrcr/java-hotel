package pl.wsb.hotel;

import java.time.LocalTime;

public class LuggageService extends SpecialService {
    public LuggageService(String name) {
        super(name);
    }

    @Override
    void orderService() {
        System.out.println("The Hotel is keeping your " + getName() + " safe.");
    }

    @Override
    boolean serviceIsAvailableAtTime(LocalTime target) {
        LocalTime start = LocalTime.parse("06:00");
        LocalTime stop = LocalTime.parse("17:00");
        return (target.isAfter(start) && target.isBefore(stop));
    }

    @Override
    String getFamilyOfService() {
        return "accommodation";
    }
}