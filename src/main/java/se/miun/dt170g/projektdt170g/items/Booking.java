package se.miun.dt170g.projektdt170g.items;

import se.miun.dt170g.projektdt170g.models.BookingEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private int bookingId;
    private String name;
    private String telephone;
    private int amount;
    private LocalDate date;
    private LocalTime time;

    public Booking() {}

    public Booking(BookingEntity booking){
        this.bookingId = booking.getBookingId();
        this.name = booking.getName();
        this.telephone = booking.getTelephone();
        this.amount = booking.getAmount();
        this.date = booking.getDate();
        this.time = booking.getTime();
    }

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
}
