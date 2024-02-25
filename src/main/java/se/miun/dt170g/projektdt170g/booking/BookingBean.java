package se.miun.dt170g.projektdt170g.booking;

import java.io.FileWriter;
import java.io.IOException;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.models.BookingEntity;
import org.primefaces.PrimeFaces;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;

// Existing class annotations and properties...


@Named
@SessionScoped
public class BookingBean implements Serializable {

    @Inject
    private BookingAPI bookingAPI;
    private int amount;

    public BookingAPI getBookingAPI() {
        return bookingAPI;
    }

    public BookingEntity getBookingEntity() {
        return bookingEntity;
    }

    private String selectedTime; // The selected time

    public void setBookingAPI(BookingAPI bookingAPI) {
        this.bookingAPI = bookingAPI;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setBookingEntity(BookingEntity bookingEntity) {
        this.bookingEntity = bookingEntity;
    }

    private List<String> availableTimes; // Available times list

    public int getStep() {
        return step;
    }

    private int step = 2;
    private boolean showMoreThanSixInfo = false; // Flag to control the message display

    // Getters and setters
    public int getAmounts() {
        return amount;
    }



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
/*
    public void setAmount(int amount) {
        bookingEntity.setAmount(amount);
    }
*/
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



    public static void logBooking(String amount, String date, String time, String name, String telephone) {
        try {
            FileWriter writer = new FileWriter("booking_log.txt", true);
            writer.write("Antal gäster: " + amount + "\n");
            writer.write("Datum: " + date + "\n");
            writer.write("Tid: " + time + "\n");
            writer.write("Namn: " + name + "\n");
            writer.write("Telefonnummer: " + telephone + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////

    public void setAmount(int amount) {
        bookingEntity.setAmount(amount);
        // Adjusted to directly check and set the flag based on the amount
        showMoreThanSixInfo = (amount > 6);
        if (showMoreThanSixInfo) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "För bokning för fler än 6 personer, kontakta oss direkt."));
        }
    }

    public boolean isShowMoreThanSixInfo() {
        return showMoreThanSixInfo;
    }


    // The rest of your getters and setters for bookingEntity's properties

    public void checkGuestNumber() {
        // This method can now be empty or removed if logic is moved to setAmount
    }
    public void moveToNextStep() {
        // Assume step 1 involves selecting the number of guests
        if (step == 1 && amount <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", "Vänligen välj antal gäster."));
            return; // Stay on the current step
        }
        // Add similar checks for other steps

        // If all validations pass for the current step, increment the step to move to the next one
        step++;
    }




    public void setShowMoreThanSixInfo(boolean showMoreThanSixInfo) {
        this.showMoreThanSixInfo = showMoreThanSixInfo;
    }

    public void onGuestNumberChange() {
        if (amount < 7) {
            PrimeFaces.current().executeScript("PF('modalStep2').show();");
        } else {
            // For the "7+ guests" case
            showMoreThanSixInfo = true;
        }
    }



    @PostConstruct
    public void init() {
        // Initialize your list of times here. This could also come from a database or any other source.
        availableTimes = Arrays.asList("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00");
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public String getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
        // Logic to proceed to the next step can be added here or in the listener method
    }

// Ensure other getters and setters are present



    public void validateDateTime() {
        LocalDate today = LocalDate.now();
        LocalTime openingTime = LocalTime.of(9, 0); // Booking starts at 09:00
        LocalTime closingTime = LocalTime.of(22, 0); // Booking ends at 22:00

        if (getDate() == null || getTime() == null) {
            FacesContext.getCurrentInstance().addMessage("dateSelect", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Datum och tid kan inte vara tomma."));
            FacesContext.getCurrentInstance().addMessage("timeSelect", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Datum och tid kan inte vara tomma."));
            return;
        }

        if (getDate().isBefore(today)) {
            FacesContext.getCurrentInstance().addMessage("dateSelect", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Datumet kan inte vara i det förflutna."));
        }

        if (getTime().isBefore(openingTime) || getTime().isAfter(closingTime)) {
            FacesContext.getCurrentInstance().addMessage("timeSelect", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Tiden måste vara mellan 09:00 och 22:00."));
        }
    }

    public void submit() {
        validateDateAndTime(); // Re-validating to ensure the form can be submitted
        if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
            saveDateTime();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Bokningen har sparats!"));
        }
    }

///////////////////////



        // Add validation methods for date and time
        public void validateDateAndTime() {
            LocalDate today = LocalDate.now();
            LocalTime openingTime = LocalTime.of(9, 0); // Booking starts at 09:00
            LocalTime closingTime = LocalTime.of(22, 0); // Booking ends at 22:00

            if (getDate() == null || getTime() == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Datum och tid kan inte vara tomma."));
                return;
            }

            if (getDate().isBefore(today)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Datumet kan inte vara i det förflutna."));
            }

            if (getTime().isBefore(openingTime) || getTime().isAfter(closingTime)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel", "Tiden måste vara mellan 09:00 och 22:00."));
            }
        }


        private void saveDateTime() {
            // Your existing save logic
        }
    }


