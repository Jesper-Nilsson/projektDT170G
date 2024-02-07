package se.miun.dt170g.projektdt170g.API;

public class Item {
    private int id;
    private int price;
    private String name;
    private String type;
    private String description;

    // Constructors, getters, and setters
    public Item() {}

    public Item(int id, int price, String name, String type, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
