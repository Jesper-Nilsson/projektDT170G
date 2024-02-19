package se.miun.dt170g.projektdt170g.items;

import se.miun.dt170g.projektdt170g.models.ALaCarteMenuEntity;

/**
 * this class represents a menu item in the a la carte menu
 */
public class ALaCarteItem {

    private int price;
    private String name;
    private String type;
    private String description;



    public ALaCarteItem(int aLaCarteID, int price, String name, String type, String description) {

        this.price = price;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public ALaCarteItem(ALaCarteMenuEntity aLaCarteEntity){
        this.price = aLaCarteEntity.getPrice();
        this.name = aLaCarteEntity.getName();
        this.type = aLaCarteEntity.getType();
        this.description = aLaCarteEntity.getDescription();
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



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
