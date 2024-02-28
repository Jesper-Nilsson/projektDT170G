package se.miun.dt170g.projektdt170g.API;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.BookingEntity;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Path("/bookings")
@Stateless
public class BookingAPI {
    @PersistenceContext
    private EntityManager entityManager;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookingsByDate(@QueryParam("date") Date SQLdate)  {
        List<BookingEntity> bookings;
        LocalDate date;
        date = SQLdate.toLocalDate();

        bookings = entityManager.createNamedQuery(BookingEntity.findByDate, BookingEntity.class)
                .setParameter("date", date)
                .getResultList();

        return Response.ok(bookings).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBooking(BookingEntity booking) {
        if (booking == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Booking information must be provided").build();
        }
        try {
            entityManager.persist(booking);
            return Response.status(Response.Status.CREATED).entity(booking).build();
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Error creating the booking").build();
        }
    }

}