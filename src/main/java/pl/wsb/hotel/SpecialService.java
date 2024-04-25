package pl.wsb.hotel;

import java.time.LocalTime;

public abstract class SpecialService {
    private String name;

    public SpecialService(String name) {
        this.name = name;
    }

    abstract void orderService();

    public String getName() {
        return name;
    }

    abstract boolean serviceIsAvailableAtTime(LocalTime target);

    abstract String getFamilyOfService();
}