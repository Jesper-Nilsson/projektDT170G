package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "events", schema = "dt170gprojekt", catalog = "")
public class EventsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "event_id")
    private int eventId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "image_url")
    private String imageUrl;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntity that = (EventsEntity) o;

        if (eventId != that.eventId) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
