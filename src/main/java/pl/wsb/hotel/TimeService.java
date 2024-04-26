package pl.wsb.hotel;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class TimeService extends SpecialService {
    public TimeService(String name) {
        super(name);
    }

    @Override
    void orderService() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        System.out.println("Current time: " + formatter.format(System.currentTimeMillis()));

    }

    @Override
    boolean serviceIsAvailableAtTime(LocalTime target) {
        LocalTime start = LocalTime.parse("08:00");
        LocalTime stop = LocalTime.parse("23:50");
        return (target.isAfter(start) && target.isBefore(stop));
    }

    @Override
    String getFamilyOfService() {
        return "support";
    }
}