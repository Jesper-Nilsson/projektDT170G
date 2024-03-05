package se.miun.dt170g.projektdt170g.beans;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.dt170g.projektdt170g.API.EventAPI;
import se.miun.dt170g.projektdt170g.items.Event;

import java.io.Serializable;
import java.time.LocalDate;
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

    public List<Event> getEventsItems() {
        return eventItems;
    }

    public void setEventsItems(List<Event> eventsItems) {
        this.eventItems = eventsItems;
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

    public LocalDate getDate() { return event.getDate(); }


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



