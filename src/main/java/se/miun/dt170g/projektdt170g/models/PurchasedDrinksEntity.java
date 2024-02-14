package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

@Entity
@Table(name = "purchased_drinks", schema = "dt170gprojekt", catalog = "")
public class PurchasedDrinksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "purchased_ID")
    private int purchasedId;
    @Basic
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "drink_id")
    private int drinkId;
    @Basic
    @Column(name = "price")
    private int price;

    public int getPurchasedId() {
        return purchasedId;
    }

    public void setPurchasedId(int purchasedId) {
        this.purchasedId = purchasedId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
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
        int result = purchasedId;
        result = 31 * result + orderId;
        result = 31 * result + drinkId;
        result = 31 * result + price;
        return result;
    }
}
