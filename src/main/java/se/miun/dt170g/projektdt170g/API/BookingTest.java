package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.BookingAPI;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.items.OrderDTO;
import se.miun.dt170g.projektdt170g.models.ALaCarteMenuEntity;
import se.miun.dt170g.projektdt170g.models.BookingEntity;

import jakarta.inject.Inject;
import se.miun.dt170g.projektdt170g.models.PurchasedALaCarteEntity;

import java.time.LocalDate;
import java.time.LocalTime;

@Path("/test") // Class-level Path annotation
@Transactional
public class BookingTest {
    @PersistenceContext
    private EntityManager entityManager;
    private BookingAPI bookingAPI;
    @Inject
    private OrderAPI orderAPI;

    @GET // HTTP method annotation
    @Produces(MediaType.APPLICATION_JSON) // Specifies the response content type
    public Response test() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setComment("test");
        orderDTO.setStatusMain("begun");
        orderDTO.setStatusAppetizer("none");
        orderDTO.setStatusDessert("none");
        orderDTO.setRestaurantTableId(3);
        orderDTO.setOrder_ID(1L);
        orderDTO.addFood(new ALaCarteItem(entityManager.find(ALaCarteMenuEntity.class,1L)));
        Response response = orderAPI.addOrder(orderDTO);
        entityManager.flush();
        return Response.ok(response).build(); // Return the Response object directly
    }
}
