package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

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
                query = "SELECT l FROM LunchMenuEntity l ORDER BY l.date ASC"
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
    private LocalDate date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
