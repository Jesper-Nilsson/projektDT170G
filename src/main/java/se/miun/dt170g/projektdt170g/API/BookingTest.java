package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.items.Drink;
import se.miun.dt170g.projektdt170g.items.OrderDTO;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;

import jakarta.inject.Inject;
import se.miun.dt170g.projektdt170g.models.ALaCarteMenuEntity;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;
import se.miun.dt170g.projektdt170g.models.RestaurantOrderEntity;

@Path("/test") // Class-level Path annotation
@Transactional
public class BookingTest {
    @PersistenceContext
    private EntityManager entityManager;
    private BookingAPI bookingAPI;
    @Inject
    private OrderAPI orderAPI;
    @Inject
    private ALaCarteAPI aLaCarteAPI;
    @Inject
    private LunchAPI lunchAPI;
    @Inject
    private DrinkAPI drinkAPI;

    /*@GET // HTTP method annotation
    @Produces(MediaType.APPLICATION_JSON) // Specifies the response content type
    public Response test() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setComment("test");
        orderDTO.setStatusMain("begun");
        orderDTO.setStatusAppetizer("none");
        orderDTO.setStatusDessert("none");
        orderDTO.setRestaurantTableId(3);
        orderDTO.addFood(new ALaCarteItem(entityManager.find(ALaCarteMenuEntity.class,1)));
        orderDTO.addFood(new ALaCarteItem(entityManager.find(ALaCarteMenuEntity.class,2)));
        orderDTO.addDrink(new Drink(entityManager.find(DrinksEntity.class, 1)));
        Response response = orderAPI.addOrder(orderDTO);
        return Response.ok(response).build(); // Return the Response object directly
    }*/
    @GET // HTTP method annotation
    @Produces(MediaType.APPLICATION_JSON) // Specifies the response content type
    public Response test() {
        DrinksEntity aa = entityManager.find(DrinksEntity.class,1);
        aa.setDescription("EN TOAST");
        Response response = drinkAPI.updateDrink(1,aa);
        return Response.ok(response).build(); // Return the Response object directly
    }
}
