package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;
import se.miun.dt170g.projektdt170g.items.OrderDTO;

import java.util.Collection;

@Entity
@Table(name = "restaurant_order", schema = "dt170gprojekt", catalog = "")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_order_id", nullable = false)
    private Long restaurantOrderId;
    @Basic
    @Column(name = "status_appetizer", nullable = false, length = 255)
    private String statusAppetizer;
    @Basic
    @Column(name = "status_main", nullable = false, length = 255)
    private String statusMain;
    @Basic
    @Column(name = "status_dessert", nullable = false, length = 255)
    private String statusDessert;
    @Basic
    @Column(name = "restaurant_table_id", nullable = false)
    private int restaurantTableId;
    @Basic
    @Column(name = "comment", nullable = false, length = 255)
    private String comment;

    @OneToMany(mappedBy = "restaurantOrderByOrderId")
    private Collection<PurchasedALaCarteEntity> purchasedALaCartesByRestaurantOrderId;
    @OneToMany(mappedBy = "restaurantOrderByOrderId")
    private Collection<PurchasedDrinksEntity> purchasedDrinksByRestaurantOrderId;

    public OrderEntity() {

    }

    public Long getRestaurantOrderId() {
        return restaurantOrderId;
    }
    public OrderEntity(OrderDTO orderDTO){
        this.comment = orderDTO.getComment();
        this.restaurantTableId = orderDTO.getRestaurantTableId();
        this.statusAppetizer = orderDTO.getStatusAppetizer();
        this.statusMain = orderDTO.getStatusMain();
        this.statusDessert = orderDTO.getStatusDessert();
    }

    public void setRestaurantOrderId(Long restaurantOrderId) {
        this.restaurantOrderId = restaurantOrderId;
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

        OrderEntity that = (OrderEntity) o;

        if (restaurantOrderId != that.restaurantOrderId) return false;
        if (restaurantTableId != that.restaurantTableId) return false;
        if (statusAppetizer != null ? !statusAppetizer.equals(that.statusAppetizer) : that.statusAppetizer != null)
            return false;
        if (statusMain != null ? !statusMain.equals(that.statusMain) : that.statusMain != null) return false;
        if (statusDessert != null ? !statusDessert.equals(that.statusDessert) : that.statusDessert != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = restaurantOrderId;
        result = 31 * result + (statusAppetizer != null ? statusAppetizer.hashCode() : 0);
        result = 31 * result + (statusMain != null ? statusMain.hashCode() : 0);
        result = 31 * result + (statusDessert != null ? statusDessert.hashCode() : 0);
        result = 31 * result + restaurantTableId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return Math.toIntExact(result);
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
