package pl.wsb.hotel;

import java.util.ArrayList;

public class SpecialService {
    //TUTAJ ZMIENIAMY NA: public class SpecialService
    private ArrayList<Object> SpecialServiceName = new ArrayList<>();
    public SpecialService(){
        SpecialServiceName.add("Internet");
        SpecialServiceName.add("Parking spot");
        SpecialServiceName.add("Massage");
        SpecialServiceName.add("Room Service");
        SpecialServiceName.add("Champagne");
    }
    /*
    abstract void orderService(){
        Tu jest coś fajnego ale jeszscze nie wiem co
    }
     */
    public String getSpecialService(){ for (int i = 0; i < SpecialServiceName.size(); i++){
            System.out.println(SpecialServiceName.get(i).toString());
        }
        return "";
    }

    }


