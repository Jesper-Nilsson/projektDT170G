package se.miun.dt170g.projektdt170g.beans;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.API.EventAPI;
import se.miun.dt170g.projektdt170g.items.Event;
import se.miun.dt170g.projektdt170g.models.BookingEntity;
import se.miun.dt170g.projektdt170g.models.EventsEntity;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;


@Named
@SessionScoped

public class EventsBean  implements Serializable{

    @Inject
    private EventAPI eventAPI;

    private List<Event> eventItems;
    private Event event;
    private static final Logger LOGGER = Logger.getLogger(EventsBean.class.getName());

    @PostConstruct
    public void init() {
        fetchEvents();
    }

    private void fetchEvents() {
        try {
            this.eventItems = eventAPI.getThreeNextEvents();
            LOGGER.info("Fetched events: " + eventItems);
        } catch (Exception e) {
            LOGGER.severe("Error fetching events: " + e.getMessage());
        }
    }

    // The rest of your getters and setters for the bean properties.
    // ...

    public List<Event> getEventsEntities() {
        return eventItems;
    }

    public void setEventsEntities(List<Event> eventsEntities) {
        this.eventItems = eventsEntities;
    }



    // Getters and Setters

    public List<Event> getEvents() {
        return eventItems;
    }




    public String getName() {
        return event.getName();
    }

    public void setName(String name) {
        event.setName(name);
    }

    public LocalDate getDate() {
        if (this.event != null) {
            return event.getDate();
        } else {
            // Handle the case where events is null, possibly by logging or throwing a more descriptive error
            return null; // or throw new IllegalStateException("Events is not initialized.");
        }
    }


    public void setDate(LocalDate date) {
        event.setDate(date);
    }

    //public String getFormattedDate() { return event.getFormattedDate(); }

    public int getPrice() {
        return event.getPrice();
    }

    public void setPrice(int price) {
        event.setPrice(price);
    }

    public String getDescription() {
        return event.getDescription();
    }

    public void setDescription(String description) {
        event.setDescription(description);
    }

    public String getImageUrl() {
        return event.getImagePath();
    }

}



