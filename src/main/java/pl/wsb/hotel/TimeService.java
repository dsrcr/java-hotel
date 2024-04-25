package pl.wsb.hotel;

import java.text.SimpleDateFormat;

public class TimeService extends SpecialService {
    public TimeService(String name) {
        super(name);
    }

    @Override
    void orderService() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        System.out.println("Current time: " + formatter.format(System.currentTimeMillis()));

    }
}