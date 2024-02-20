package se.miun.dt170g.projektdt170g.API;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.models.BookingEntity;

import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;

@Path("/test") // Class-level Path annotation
public class BookingTest {

    @Inject
    private BookingAPI bookingAPI;

    @GET // HTTP method annotation
    @Produces(MediaType.TEXT_PLAIN) // Specifies the response content type
    public Response test() {
        BookingEntity booking = new BookingEntity();
        booking.setAmount(3);
        booking.setDate(LocalDate.of(2024,2,21));
        booking.setTime(LocalTime.of(19,30));
        booking.setName("jesper");
        booking.setTelephone("06512453");

        Response response = bookingAPI.createBooking(booking);
        return response; // Return the Response object directly
    }
}
