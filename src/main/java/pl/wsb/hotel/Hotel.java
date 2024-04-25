package pl.wsb.hotel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<SpecialService> specialServices;
    private Client[] clients;
    private RoomReservation[] reservations;
    private Room[] rooms;

    public Hotel(String name) {
        this.name = name;
        this.specialServices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSpecialService(SpecialService service) {
        this.specialServices.add(service);
    }

    public SpecialService[] getSpecialServices() {
        return this.specialServices.toArray(new SpecialService[0]);
    }

}