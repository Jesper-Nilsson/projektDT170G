package se.miun.dt170g.projektdt170g.API;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
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

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;

import jakarta.inject.Inject;
import se.miun.dt170g.projektdt170g.models.ALaCarteMenuEntity;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;
import se.miun.dt170g.projektdt170g.models.RestaurantOrderEntity;


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
    public Response test() throws IOException, InterruptedException {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setComment("test");
        orderDTO.setStatusMain("Skickat");
        orderDTO.setStatusAppetizer("Skickat");
        orderDTO.setStatusDessert("Skickat");
        orderDTO.setRestaurantTableId(3);
        orderDTO.setOrderStatus(true);
        orderDTO.addFood(new ALaCarteItem(entityManager.find(ALaCarteMenuEntity.class,1)));
        orderDTO.addFood(new ALaCarteItem(entityManager.find(ALaCarteMenuEntity.class,2)));
        orderDTO.addFood(new ALaCarteItem(entityManager.find(ALaCarteMenuEntity.class,3)));
        orderDTO.addDrink(new Drink(entityManager.find(DrinksEntity.class, 1)));
        orderDTO.addDrink(new Drink(entityManager.find(DrinksEntity.class, 2)));
        //Response response = orderAPI.addOrder(orderDTO);

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(orderDTO);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/projektDT170G-1.0-SNAPSHOT/api/order")) // Specify the target URL
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return Response.ok(response.body()).build(); // Return the HTTP response body


        //return Response.ok(response).build(); // Return the Response object directly
    }






}
