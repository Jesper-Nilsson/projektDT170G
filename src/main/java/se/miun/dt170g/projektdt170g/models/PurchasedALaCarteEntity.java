package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;

@Entity
@Table(name = "purchased_a_la_carte", schema = "dt170gprojekt", catalog = "")
public class PurchasedALaCarteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "purchased_ID", nullable = false)
    private Long purchasedId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @Basic
    @Column(name = "a_la_carte_id", nullable = false)
    private Long aLaCarteId;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "restaurant_order_id", nullable = false,updatable = false, insertable = false)
    private OrderEntity restaurantOrderByOrderId;
    @ManyToOne
    @JoinColumn(name = "a_la_carte_id", referencedColumnName = "a_la_carte_id", nullable = false,updatable = false, insertable = false)
    private ALaCarteMenuEntity aLaCarteMenuByALaCarteId;

    public PurchasedALaCarteEntity(ALaCarteItem aLaCarteItem, OrderEntity order){
        this.aLaCarteId = aLaCarteItem.getaLaCarteID();
        this.orderId = order.getRestaurantOrderId();
    }

    public PurchasedALaCarteEntity() {

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

    public Long getaLaCarteId() {
        return aLaCarteId;
    }

    public void setaLaCarteId(Long aLaCarteId) {
        this.aLaCarteId = aLaCarteId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasedALaCarteEntity that = (PurchasedALaCarteEntity) o;

        if (purchasedId != that.purchasedId) return false;
        if (orderId != that.orderId) return false;
        if (aLaCarteId != that.aLaCarteId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = purchasedId;
        result = 31 * result + orderId;
        result = 31 * result + aLaCarteId;

        return Math.toIntExact(result);
    }

    public OrderEntity getRestaurantOrderByOrderId() {
        return restaurantOrderByOrderId;
    }

    public void setRestaurantOrderByOrderId(OrderEntity restaurantOrderByOrderId) {
        this.restaurantOrderByOrderId = restaurantOrderByOrderId;
    }

    public ALaCarteMenuEntity getaLaCarteMenuByALaCarteId() {
        return aLaCarteMenuByALaCarteId;
    }

    public void setaLaCarteMenuByALaCarteId(ALaCarteMenuEntity aLaCarteMenuByALaCarteId) {
        this.aLaCarteMenuByALaCarteId = aLaCarteMenuByALaCarteId;
    }
}
