package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;
import se.miun.dt170g.projektdt170g.items.Event;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
@NamedQueries({
        @NamedQuery(
                name = "EventsEntity.findComingDates",
                query = "SELECT l FROM EventsEntity l WHERE l.date >= :date ORDER BY l.date ASC"
        )
})

@Entity
@Table(name = "events", schema = "dt170gprojekt", catalog = "")
public class EventsEntity {

    public static final String findAfterDate = "EventsEntity.findComingDates";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "event_id", nullable = false)
    private int eventId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Basic
    @Column(name = "time", nullable = false)
    private LocalTime time;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Basic
    @Column(name = "image_url", nullable = false, length = 255)
    private String imageUrl;

    public EventsEntity(){}
    public EventsEntity(Event event){
        this.eventId = event.getEventID();
        this.name = event.getName();
        this.price = event.getPrice();
        this.date = event.getDate();
        this.time = event.getTime();
        this.description = event.getDescription();
        this.imageUrl = event.getImagePath();
    }

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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
