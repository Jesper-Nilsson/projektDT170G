package se.miun.dt170g.projektdt170g.admin;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class AdminBean {

    // This method could be called when the "Event" button is pressed
    public String goToEventAdmin() {
        // Preprocess or prepare data here, such as loading event lists, checking permissions, etc.

        return "eventAdmin?faces-redirect=true"; // Navigate to the eventAdmin.xhtml page
    }

    // You can have additional methods for "insert new event", "update event", and "delete event" actions
}
