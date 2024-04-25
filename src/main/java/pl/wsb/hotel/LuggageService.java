package pl.wsb.hotel;

public class LuggageService extends SpecialService {
    public LuggageService(String name) {
        super(name);
    }

    @Override
    void orderService() {
        System.out.println("The Hotel is keeping your " + getName() + " safe.");
    }

}