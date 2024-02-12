
package se.miun.dt170g.projektdt170g.admin;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.Date;

@Named
@RequestScoped
public class EventAdminBean {
    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getEventIdToDelete() {
        return eventIdToDelete;
    }

    public void setEventIdToDelete(Long eventIdToDelete) {
        this.eventIdToDelete = eventIdToDelete;
    }

    private String eventDescription;
    private Date eventDate;
    private String imageUrl;

    // Properties specific to other actions
    private Long eventIdToDelete;
    private String action; // Define the action property

    // Getter and setter for the action property
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    // Other properties and methods...
}
