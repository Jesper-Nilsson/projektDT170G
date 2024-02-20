package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.items.Drink;

@Entity
@Table(name = "purchased_drinks", schema = "dt170gprojekt", catalog = "")
public class PurchasedDrinksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "purchased_ID", nullable = false)
    private Long purchasedId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @Basic
    @Column(name = "drink_id", nullable = false)
    private Long drinkId;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "restaurant_order_id", nullable = false,updatable = false, insertable = false)
    private OrderEntity restaurantOrderByOrderId;
    @ManyToOne
    @JoinColumn(name = "drink_id", referencedColumnName = "drink_id", nullable = false,updatable = false, insertable = false)
    private DrinksEntity drinksByDrinkId;

    public PurchasedDrinksEntity(Drink drink, OrderEntity order){
        this.drinkId = drink.getDrink_ID();
        this.orderId = order.getRestaurantOrderId();
    }

    public PurchasedDrinksEntity() {

    }

    public Long getPurchasedId() {
        return purchasedId;
    }

    public void setPurchasedId(Long purchasedId) {
        this.purchasedId = purchasedId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasedDrinksEntity that = (PurchasedDrinksEntity) o;

        if (purchasedId != that.purchasedId) return false;
        if (orderId != that.orderId) return false;
        if (drinkId != that.drinkId) return false;
        if (price != that.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = purchasedId;
        result = 31 * result + orderId;
        result = 31 * result + drinkId;
        result = 31 * result + price;
        return Math.toIntExact(result);
    }

    public OrderEntity getRestaurantOrderByOrderId() {
        return restaurantOrderByOrderId;
    }

    public void setRestaurantOrderByOrderId(OrderEntity restaurantOrderByOrderId) {
        this.restaurantOrderByOrderId = restaurantOrderByOrderId;
    }

    public DrinksEntity getDrinksByDrinkId() {
        return drinksByDrinkId;
    }

    public void setDrinksByDrinkId(DrinksEntity drinksByDrinkId) {
        this.drinksByDrinkId = drinksByDrinkId;
    }
}
