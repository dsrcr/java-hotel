package pl.wsb.hotel;

import java.lang.reflect.Array;

public class Hotel {
    private String name;
    private SpecialService SpecialService;
    private Client[] clients;
    private RoomReservation[] reservations;
    private Room[] rooms;

    public Hotel(String name){
        this.name = name;
        this.SpecialService = SpecialService;
    }

    public String getName() {return name; }
}