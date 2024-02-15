package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

@Entity
@Table(name = "purchased_a_la_carte", schema = "dt170gprojekt")
public class PurchasedALaCarteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "purchased_ID", nullable = false)
    private int purchasedId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "a_la_carte_id", nullable = false)
    private int aLaCarteId;
    @Basic
    @Column(name = "antal", nullable = false)
    private int antal;
    /*@ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "restaurant_order_id", nullable = false)
    private RestaurantOrderEntity restaurantOrderByOrderId;
    @ManyToOne
    @JoinColumn(name = "a_la_carte_id", referencedColumnName = "a_la_carte_id", nullable = false)
    private ALaCarteMenuEntity aLaCarteMenuByALaCarteId;*/

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

    public int getaLaCarteId() {
        return aLaCarteId;
    }

    public void setaLaCarteId(int aLaCarteId) {
        this.aLaCarteId = aLaCarteId;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasedALaCarteEntity that = (PurchasedALaCarteEntity) o;

        if (purchasedId != that.purchasedId) return false;
        if (orderId != that.orderId) return false;
        if (aLaCarteId != that.aLaCarteId) return false;
        if (antal != that.antal) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchasedId;
        result = 31 * result + orderId;
        result = 31 * result + aLaCarteId;
        result = 31 * result + antal;
        return result;
    }

    /*public RestaurantOrderEntity getRestaurantOrderByOrderId() {
        return restaurantOrderByOrderId;
    }

    public void setRestaurantOrderByOrderId(RestaurantOrderEntity restaurantOrderByOrderId) {
        this.restaurantOrderByOrderId = restaurantOrderByOrderId;
    }

    public ALaCarteMenuEntity getaLaCarteMenuByALaCarteId() {
        return aLaCarteMenuByALaCarteId;
    }

    public void setaLaCarteMenuByALaCarteId(ALaCarteMenuEntity aLaCarteMenuByALaCarteId) {
        this.aLaCarteMenuByALaCarteId = aLaCarteMenuByALaCarteId;
    }*/
}
