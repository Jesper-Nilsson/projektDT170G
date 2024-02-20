package se.miun.dt170g.projektdt170g.models;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.time.LocalDate;

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
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Basic
    @Column(name = "time", nullable = false)
    private LocalTime time;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingEntity that = (BookingEntity) o;

        if (bookingId != that.bookingId) return false;
        if (telephone != that.telephone) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookingId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
