package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.sql.Date;
@NamedQueries({
        @NamedQuery(
                name = "LunchMenuEntity.findByDate",
                query = "SELECT l FROM LunchMenuEntity l WHERE l.date = :date"
        ),
        @NamedQuery(
                name = "LunchMenuEntity.findBetweenDates",
                query = "SELECT l FROM LunchMenuEntity l WHERE l.date BETWEEN :startDate AND :endDate"
        ),
        @NamedQuery(
                name = "LunchMenuEntity.findAll",
                query = "SELECT l FROM LunchMenuEntity l"
        )
})
@Entity
@Table(name = "lunch_menu", schema = "dt170gprojekt", catalog = "")
public class LunchMenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lunch_id", nullable = false)
    private int lunchId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
        this.lunchId = lunchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

        LunchMenuEntity that = (LunchMenuEntity) o;

        if (lunchId != that.lunchId) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lunchId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
