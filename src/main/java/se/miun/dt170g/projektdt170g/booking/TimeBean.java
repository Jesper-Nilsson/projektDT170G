package se.miun.dt170g.projektdt170g.booking;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@SessionScoped
public class TimeBean implements Serializable {
    private static final long serialVersionUID = 1L;


    @PersistenceContext
    private EntityManager entityManager;

    private Date dateTime;
    // Removed datePart and timePart since they are derived properties

    // SimpleDateFormat for outputting date and time
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDatePart() {
        // Extract date part as String
        return dateFormat.format(dateTime);
    }

    public String getTimePart() {
        // Extract time part as String
        return timeFormat.format(dateTime);
    }

    public void submit() {
        // Save logic here, assuming you're saving dateTime as well as separate date and time parts
        saveDateTime();
    }

    private void saveDateTime() {
        // Example save logic, adjust according to your actual entity and persistence logic
        // This is where you would separate dateTime into date and time components and save them
        System.out.println("Saving to database: " + dateTime);
        // Actual database saving logic goes here
    }
}
