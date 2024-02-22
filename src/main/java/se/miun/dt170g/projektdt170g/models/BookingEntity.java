package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
@NamedQueries({
        @NamedQuery(
                name = "BookingEntity.findDate",
                query = "SELECT l FROM BookingEntity l WHERE l.date = :date"
        )
})
@Entity
@Table(name = "booking", schema = "dt170gprojekt", catalog = "")
public class BookingEntity {
    public static final String findByDate = "BookingEntity.findDate";
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "booking_id", nullable = false)
    private int bookingId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "telephone", nullable = false, length = 12)
    private String telephone;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "time", nullable = false)
    private Time time;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
