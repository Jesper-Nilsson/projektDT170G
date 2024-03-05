package se.miun.dt170g.projektdt170g.beans;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.items.Booking;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Calendar;


@Named
@SessionScoped

public class BookingBean implements Serializable {
    @Inject
    private BookingAPI bookingAPI;
    private Booking booking;
    private String minBookingDate = getCurrentDate();


    public String getName() {
        return booking.getName();
    }

    public void setName(String name) {
        booking.setName(name);
    }

    public String getTelephone() {
        return booking.getTelephone();
    }

    public void setTelephone(String telephone) {
        booking.setTelephone(telephone);
    }

    public int getAmount() {
        return booking.getAmount();
    }

    public void setAmount(int amount) {
        booking.setAmount(amount);
    }

    public LocalDate getDate() {
        return booking.getDate();
    }

    public void setDate(LocalDate date) {
        booking.setDate(date);
    }

    public LocalTime getTime() {
        return booking.getTime();
    }

    public void setTime(LocalTime time) {
        booking.setTime(time);
    }

    public void submit() {
        // Save logic here, assuming you're saving dateTime as well as separate date and time parts
        bookingAPI.createBooking(booking);
    }

    public String getMinBookingDate() {
        return minBookingDate;
    }

    public String getCurrentDate() {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Get the Date object corresponding to the adjusted date
        Date currentDate = calendar.getTime();

        // Format the date using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(currentDate);
    }
}
