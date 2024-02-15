package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "restaurant_order", schema = "dt170gprojekt", catalog = "")
public class RestaurantOrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_order_id")
    private int restaurantOrderId;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "restaurant_table_id")
    private int restaurantTableId;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "status_appetizer")
    private String statusAppetizer;
    @Basic
    @Column(name = "status_main")
    private String statusMain;
    @Basic
    @Column(name = "status_dessert")
    private String statusDessert;
    @OneToMany(mappedBy = "restaurantOrderByOrderId")
    private Collection<PurchasedALaCarteEntity> purchasedALaCartesByRestaurantOrderId;
    @OneToMany(mappedBy = "restaurantOrderByOrderId")
    private Collection<PurchasedDrinksEntity> purchasedDrinksByRestaurantOrderId;

    public int getRestaurantOrderId() {
        return restaurantOrderId;
    }

    public void setRestaurantOrderId(int restaurantOrderId) {
        this.restaurantOrderId = restaurantOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantOrderEntity that = (RestaurantOrderEntity) o;

        if (restaurantOrderId != that.restaurantOrderId) return false;
        if (restaurantTableId != that.restaurantTableId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = restaurantOrderId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + restaurantTableId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
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

    public Collection<PurchasedALaCarteEntity> getPurchasedALaCartesByRestaurantOrderId() {
        return purchasedALaCartesByRestaurantOrderId;
    }

    public void setPurchasedALaCartesByRestaurantOrderId(Collection<PurchasedALaCarteEntity> purchasedALaCartesByRestaurantOrderId) {
        this.purchasedALaCartesByRestaurantOrderId = purchasedALaCartesByRestaurantOrderId;
    }

    public Collection<PurchasedDrinksEntity> getPurchasedDrinksByRestaurantOrderId() {
        return purchasedDrinksByRestaurantOrderId;
    }

    public void setPurchasedDrinksByRestaurantOrderId(Collection<PurchasedDrinksEntity> purchasedDrinksByRestaurantOrderId) {
        this.purchasedDrinksByRestaurantOrderId = purchasedDrinksByRestaurantOrderId;
    }
}
