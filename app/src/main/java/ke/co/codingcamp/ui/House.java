package ke.co.codingcamp.ui;

public class House {

    private long id;
    private String location;
    private double price;
    private int number_of_rooms;
    private String type_of_house;
    private int size_in_square_feet;
    private String property_owner;
    private String phone_number;
    private int floor;
    private boolean is_deposit_required;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public String getType_of_house() {
        return type_of_house;
    }

    public void setType_of_house(String type_of_house) {
        this.type_of_house = type_of_house;
    }

    public int getSize_in_square_feet() {
        return size_in_square_feet;
    }

    public void setSize_in_square_feet(int size_in_square_feet) {
        this.size_in_square_feet = size_in_square_feet;
    }

    public String getProperty_owner() {
        return property_owner;
    }

    public void setProperty_owner(String property_owner) {
        this.property_owner = property_owner;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isIs_deposit_required() {
        return is_deposit_required;
    }

    public void setIs_deposit_required(boolean is_deposit_required) {
        this.is_deposit_required = is_deposit_required;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
