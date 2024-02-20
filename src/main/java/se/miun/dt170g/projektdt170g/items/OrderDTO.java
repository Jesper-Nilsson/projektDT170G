package se.miun.dt170g.projektdt170g.items;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;
import se.miun.dt170g.projektdt170g.models.PurchasedALaCarteEntity;
import se.miun.dt170g.projektdt170g.models.PurchasedDrinksEntity;

import java.util.*;

public class OrderDTO {

    private Long order_ID;

    private String statusAppetizer;

    private String statusMain;

    private String statusDessert;

    private int restaurantTableId;

    private String comment;


    private ArrayList<ALaCarteItem> foods;

    private ArrayList<Drink> drinks;

    public OrderDTO(Long order_ID, String statusAppetizer, String statusMain, String statusDessert, int restaurantTableId, String comment, ArrayList<ALaCarteItem> foods, ArrayList<Drink> drinks) {
        this.order_ID = order_ID;
        this.statusAppetizer = statusAppetizer;
        this.statusMain = statusMain;
        this.statusDessert = statusDessert;
        this.restaurantTableId = restaurantTableId;
        this.comment = comment;
        this.foods = foods;
        this.drinks = drinks;
    }

    public OrderDTO() {
    foods = new ArrayList<ALaCarteItem>();
    drinks = new ArrayList<Drink>();
    }

    public Long getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Long order_ID) {
        this.order_ID = order_ID;
    }

    public String getStatusAppetizer() {
        return statusAppetizer;
    }

    public void setStatusAppetizer(String statusAppetizer) {
        this.statusAppetizer = statusAppetizer;
    }

    public String getStatusMain() {
        return statusMain;
    }

    public void setStatusMain(String statusMain) {
        this.statusMain = statusMain;
    }

    public String getStatusDessert() {
        return statusDessert;
    }

    public void setStatusDessert(String statusDessert) {
        this.statusDessert = statusDessert;
    }

    public int getRestaurantTableId() {
        return restaurantTableId;
    }

    public void setRestaurantTableId(int restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ALaCarteItem> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<ALaCarteItem> foods) {
        this.foods = foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    };
    public void addFood(ALaCarteItem food){
        foods.add(food);
    };

}
