package se.miun.dt170g.projektdt170g.beans;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.API.EventAPI;
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

    private List<EventsEntity> eventsEntities;
    private EventsEntity events;
    private static final Logger LOGGER = Logger.getLogger(EventsBean.class.getName());

    @PostConstruct
    public void init() {
        fetchEvents();
    }

    private void fetchEvents() {
        try {
            this.eventsEntities = eventAPI.getThreeNextEvents();
            LOGGER.info("Fetched events: " + eventsEntities);
        } catch (Exception e) {
            LOGGER.severe("Error fetching events: " + e.getMessage());
        }
    }

    // The rest of your getters and setters for the bean properties.
    // ...

    public List<EventsEntity> getEventsEntities() {
        return eventsEntities;
    }

    public void setEventsEntities(List<EventsEntity> eventsEntities) {
        this.eventsEntities = eventsEntities;
    }



    // Getters and Setters

    public List<EventsEntity> getEvents() {
        return eventsEntities;
    }




    public String getName() {
        return events.getName();
    }

    public void setName(String name) {
        events.setName(name);
    }

    public LocalDate getDate() {
        return events.getDate();
    }

    public void setDate(LocalDate date) {
        events.setDate(date);
    }

    public int getPrice() {
        return events.getPrice();
    }

    public void setPrice(int price) {
        events.setPrice(price);
    }

    public String getDescription() {
        return events.getDescription();
    }

    public void setDescription(String description) {
        events.setDescription(description);
    }

    public String getImageUrl() {
        return events.getImageUrl();
    }

}



