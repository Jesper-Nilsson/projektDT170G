

package se.miun.dt170g.projektdt170g.admin;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.ViewHandler;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.ALaCarteAPI;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.net.URI;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;
import se.miun.dt170g.projektdt170g.items.Booking;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;


@Named
@ViewScoped
public class BookingAdminBean implements Serializable {



    @Inject
    private BookingAPI bookingAPI;


    private String action; // Define the action property

    private String message = "aa";

    List<Booking> bookings;

    @PostConstruct
    public void init() {
        this.bookings = bookingAPI.getBookingsByDate(LocalDate.now().toString());
    }





    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    // Temporary here for update a la carte




    public String getAction() {
        return action;
    }

    public void setAction(String action) {


        this.action = action;
    }








}
