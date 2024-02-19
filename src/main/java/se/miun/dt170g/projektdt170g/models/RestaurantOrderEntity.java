package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.util.Collection;
/*@NamedQueries({
        @NamedQuery(name = "Order.findWithDetails",
                query = "SELECT o FROM RestaurantOrderEntity o " +
                        "LEFT JOIN FETCH o.purchasedALaCartesByRestaurantOrderId " +
                        "LEFT JOIN FETCH o.purchasedDrinksByRestaurantOrderId " +
                        "WHERE o.restaurantOrderId= :orderId")
})*/

@Entity
@Table(name = "restaurant_order", schema = "dt170gprojekt", catalog = "")
public class RestaurantOrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_order_id", nullable = false)
    private int restaurantOrderId;
    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @Basic
    @Column(name = "restaurant_table_id", nullable = false)
    private int restaurantTableId;
    @Basic
    @Column(name = "comment", nullable = false, length = 255)
    private String comment;
   /* @OneToMany(mappedBy = "restaurantOrderByOrderId")
    private Collection<PurchasedALaCarteEntity> purchasedALaCartesByRestaurantOrderId;
    @OneToMany(mappedBy = "restaurantOrderByOrderId")
    private Collection<PurchasedDrinksEntity> purchasedDrinksByRestaurantOrderId;*/

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

    /*public Collection<PurchasedALaCarteEntity> getPurchasedALaCartesByRestaurantOrderId() {
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
    }*/
}
