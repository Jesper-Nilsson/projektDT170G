package se.miun.dt170g.projektdt170g.API;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.items.Drink;
import se.miun.dt170g.projektdt170g.items.OrderDTO;
import se.miun.dt170g.projektdt170g.models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/order")
@Stateless
public class OrderAPI {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource(name = "jdbc/database")
    private DataSource dataSource;;

    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO getOrder(@QueryParam("orderID") int orderID,
                             @QueryParam("kitchen") boolean kitchen,
                             @QueryParam("service") boolean service) {

        //check orderID if not given, error or just everything today

        OrderDTO order_return = new OrderDTO();
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(OrderDTO orderDTO) {
        try (Connection connection = dataSource.getConnection()) {
            // Disable auto-commit


            // Insert the order and retrieve the generated key
            String insertOrderSQL = "INSERT INTO restaurant_order (status_appetizer, status_main, status_dessert,restaurant_table_id,comment) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement orderStatement = connection.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS)) {

                orderStatement.setString(1, orderDTO.getStatusAppetizer());
                 orderStatement.setString(2, orderDTO.getStatusMain());
                orderStatement.setString(3, orderDTO.getStatusDessert());
                orderStatement.setInt(4, orderDTO.getRestaurantTableId());
                orderStatement.setString(5, orderDTO.getComment());
                // ...

                int affectedRows = orderStatement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating order failed, no rows affected.");
                }

                try (ResultSet generatedKeys = orderStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int orderId = generatedKeys.getInt(1);  // Assuming the ID is of type long

                        // Now insert the purchased a la carte items
                        String insertPurchasedItemSQL = "INSERT INTO purchased_a_la_carte (order_id, a_la_carte_id) VALUES (?, ?)";
                        try (PreparedStatement itemStatement = connection.prepareStatement(insertPurchasedItemSQL)) {
                            for (ALaCarteItem item : orderDTO.getFoods()) {
                                itemStatement.setInt(1, orderId);
                                itemStatement.setInt(2, item.getaLaCarteID());
                                itemStatement.executeUpdate();
                            }
                        }
                    } else {
                        throw new SQLException("Creating order failed, no ID obtained.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // If there is an exception, you might want to rollback the transaction
            try (Connection connection = dataSource.getConnection()) {
                connection.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        return Response.ok().build();
    }





}
