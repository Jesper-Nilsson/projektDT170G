package se.miun.dt170g.projektdt170g.API;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.items.Drink;
import se.miun.dt170g.projektdt170g.items.Order;
import se.miun.dt170g.projektdt170g.items.OrderDTO;
import se.miun.dt170g.projektdt170g.models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/order")
public class OrderAPI {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO getOrder(@QueryParam("orderID") int orderID,
                             @QueryParam("kitchen") boolean kitchen,
                             @QueryParam("service") boolean service) {

        //check orderID if not given, error or just everything today

        OrderDTO order_return = new OrderDTO();
        if (kitchen) {

        } else if (service) {

        }
        RestaurantOrderEntity test = entityManager.find(RestaurantOrderEntity.class,orderID);

        order_return.setOrder_ID(test.getRestaurantOrderId());
        order_return.setStatusAppetizer(test.getStatusAppetizer());
        order_return.setStatusMain(test.getStatusMain());
        order_return.setStatusDessert(test.getStatusDessert());
        order_return.setComment(test.getComment());

        for ( PurchasedALaCarteEntity purchasedALaCarte : test.getPurchasedALaCartesByRestaurantOrderId()){
            ALaCarteMenuEntity food = entityManager.find(ALaCarteMenuEntity.class,purchasedALaCarte.getaLaCarteId());
            order_return.addFood(new ALaCarteItem(food));
        }
        for (PurchasedDrinksEntity purchasedDrinks : test.getPurchasedDrinksByRestaurantOrderId() ){
            DrinksEntity drink = entityManager.find(DrinksEntity.class, purchasedDrinks.getDrinkId());
            order_return.addDrink(new Drink(drink));
        }
        return order_return;
    }


}
