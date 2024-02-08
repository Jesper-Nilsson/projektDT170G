package se.miun.dt170g.projektdt170g.models;

/**
 * this class represents a menu item in the a la carte menu
 */
public class ALaCarteItem {
    private int dinner_id;
    private int price;
    private String name;
    private String type;
    private String description;



    public ALaCarteItem(int dinner_id, int price, String name, String type, String description) {
        this.dinner_id = dinner_id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.description = description;
    }


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

    public int getDinner_id() {
        return dinner_id;
    }

    public void setDinner_id(int dinner_id) {
        this.dinner_id = dinner_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
