package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

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
}
