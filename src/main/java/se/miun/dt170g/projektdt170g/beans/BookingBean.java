package se.miun.dt170g.projektdt170g.beans;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.items.Booking;
import se.miun.dt170g.projektdt170g.models.BookingEntity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;
import java.util.List;


@Named
@SessionScoped

public class BookingBean implements Serializable {
    @Inject
    private BookingAPI bookingAPI;
    private Booking bookingItem = new Booking();
    private String minBookingDate = getCurrentDate();
    private List<Booking> bookingList;


    public String getName() {
        return bookingItem.getName();
    }

    public void setName(String name) {
        bookingItem.setName(name);
    }

    public String getTelephone() {
        return bookingItem.getTelephone();
    }

    public void setTelephone(String telephone) {
        bookingItem.setTelephone(telephone);
    }

    public int getAmount() {

        return bookingItem.getAmount();
    }

    public void setAmount(int amount) {
        bookingItem.setAmount(amount);
    }

    public LocalDate getDate() {

        return bookingItem.getDate();
    }
    public String getFormattedDate() {
        if (bookingItem.getDate() != null) {
            return bookingItem.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return ""; // Return an empty string or a default value as necessary
    }

    public void setDate(LocalDate date) {
        bookingItem.setDate(date);
    }

    public LocalTime getTime() {
        return bookingItem.getTime();
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limits) {
        this.limit =  bookingList.size();
    }

    private int limit;
    public void setTime(LocalTime time)
    {

        bookingItem.setTime(time);
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


    public String getBookingLimitMessage() {
        return bookingLimitMessage;
    }

    private String bookingLimitMessage = null;


    public void submit() {
        bookingList = bookingAPI.getBookingsByDate(bookingItem.getDate().toString());
        if (bookingList.size() < 4) {
            bookingAPI.createBooking(bookingItem);
            bookingLimitMessage = null; // Reset the message
        } else {
            bookingLimitMessage = "Bokningsgränsen nådd för detta datum. Ring eller maila oss för din bokning på 070000000, anton@gmail.com";


        }

    }

}

