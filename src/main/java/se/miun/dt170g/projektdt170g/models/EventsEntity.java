package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(
                name = "EventsEntity.findComingDates",
                query = "SELECT e FROM EventsEntity e WHERE e.date > :date ORDER BY e.date ASC"
        )
})

@Entity
@Table(name = "events", schema = "dt170gprojekt")
public class EventsEntity {

    public static final String findAfterDate = "EventsEntity.findComingDates";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private int eventId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    // Assuming 'date' is of type TIMESTAMP in the database and mapped to LocalDate in Java.
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "image_url", nullable = false, length = 255)
    private String imageUrl;

    // Getters and setters

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Removed the getTime and setTime methods as the 'time' column does not exist in the schema.
}
