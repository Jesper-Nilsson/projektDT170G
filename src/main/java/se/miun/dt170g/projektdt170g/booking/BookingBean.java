package se.miun.dt170g.projektdt170g.booking;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.models.BookingEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Named
@SessionScoped

public class BookingBean implements Serializable {

    @Inject
    private BookingAPI bookingAPI;
    private BookingEntity bookingEntity = new BookingEntity();


    public String getName() {
        return bookingEntity.getName();
    }

    public void setName(String name) {
        bookingEntity.setName(name);
    }

    public String getTelephone() {
        return bookingEntity.getTelephone();
    }

    public void setTelephone(String telephone) {
        bookingEntity.setTelephone(telephone);
    }

    public int getAmount() {
        return bookingEntity.getAmount();
    }

    public void setAmount(int amount) {
        bookingEntity.setAmount(amount);
    }

    public LocalDate getDate() {
        return bookingEntity.getDate();
    }

    public void setDate(LocalDate date) {
        bookingEntity.setDate(date);
    }

    public LocalTime getTime() {
        return bookingEntity.getTime();
    }

    public void setTime(LocalTime time) {
        bookingEntity.setTime(time);
    }
    public void submit() {
        // Save logic here, assuming you're saving dateTime as well as separate date and time parts
        saveDateTime();
    }

    private void saveDateTime() {
        // Example save logic, adjust according to your actual entity and persistence logic
        // This is where you would separate dateTime into date and time components and save them

        // Actual database saving logic goes here
    }
}
