package se.miun.dt170g.projektdt170g.webBeans;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class BookingBean implements Serializable {
    private Date date;

    // Getter and setter
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Method to save date
    public void saveDate() {
        // Implement your logic to handle the saved date
        System.out.println("Selected Date: " + date);
    }
}
