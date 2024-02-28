package se.miun.dt170g.projektdt170g.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.LunchAPI;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Named("menueBean")
@RequestScoped
public class MenueBean implements Serializable {

    @Inject
    private LunchAPI lunchAPI;

    private List<LunchMenuEntity> weeklyMenus = new ArrayList<>();
    public List<LunchMenuEntity> getWeeklyMenus() {
        return weeklyMenus;
    }
    public MenueBean() {
        // No-args constructor
    }

    @PostConstruct
    public void init() {
        try {
            fetchWeeklyMenus(); // Use this in production
           // this.weeklyMenus = createMockData(); // Use this for testing
        } catch (Exception e) {
            e.printStackTrace(); // Or use a logger to log the exception
        }
    }

    private void fetchWeeklyMenus() {
        Response response = lunchAPI.getLunch(true, false);
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            this.weeklyMenus = response.readEntity(new GenericType<List<LunchMenuEntity>>(){});
        } else {
            // Handle the error appropriately, maybe log it or set weeklyMenus to an empty list
            this.weeklyMenus = new ArrayList<>();
        }
    }

    private List<LunchMenuEntity> createMockData() {
        List<LunchMenuEntity> mockData = new ArrayList<>();
        // Add your mock data here
        mockData.add(new LunchMenuEntity( "Mock Pasta", "Delicious pasta with tomato sauce", LocalDate.now(), 100));
        // Repeat for other days of the week
        return mockData;
    }

    // ... existing methods ...

    /**
     * Inner class to represent a menu item with the day name.
     */
    public static class MenuWithDayName {
        private String dayOfWeek;
        private String description;
        private int price;

        public MenuWithDayName(String dayOfWeek, String description, int price) {
            this.dayOfWeek = dayOfWeek;
            this.description = description;
            this.price = price;
        }

        // Getters and Setters
        public String getDayOfWeek() {
            return dayOfWeek;
        }

        public void setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

/*

    public String getName() {
        return lunchMenuEntity.getName() ;
    }

    public void setName(String name) {
        lunchMenuEntity.setName(name);
    }

    public String getDescription() {
        return lunchMenuEntity.getDescription();
    }

    public void setDescription(String description) {
        lunchMenuEntity.setDescription(description);
    }

    public LocalDate getDate() {
        return lunchMenuEntity.getDate();
    }

    public void setDate(LocalDate date) {
        lunchMenuEntity.setDate(date);
    }

    public int getPrice() {
        return lunchMenuEntity.getPrice();
    }

    public void setPrice(int price) {
        lunchMenuEntity.setPrice(price);
    }


*/








}
