package pl.wsb.hotel;

public class Room {
    private String id;
    private String description;
    private double area;
    private int floor;

    private boolean hasKingSizeBed;

    public Room(String id, String description, double area, int floor, boolean hasKingSizeBed) {
        this.id = id;
        this.description = description;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isHasKingSizeBed() {
        return hasKingSizeBed;
    }

    public void setHasKingSizeBed(boolean hasKingSizeBed) {
        this.hasKingSizeBed = hasKingSizeBed;
    }
}
