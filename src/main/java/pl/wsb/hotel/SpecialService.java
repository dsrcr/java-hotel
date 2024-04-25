package pl.wsb.hotel;

public abstract class SpecialService {
    private String name;

    public SpecialService(String name) {
        this.name = name;
    }

    abstract void orderService();

    public String getName() {
        return name;
    }
}