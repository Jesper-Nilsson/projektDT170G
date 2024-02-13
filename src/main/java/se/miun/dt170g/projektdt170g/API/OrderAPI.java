package se.miun.dt170g.projektdt170g.API;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g.projektdt170g.models.ALaCarteItem;
import se.miun.dt170g.projektdt170g.models.Drink;
import se.miun.dt170g.projektdt170g.models.Lunch;
import se.miun.dt170g.projektdt170g.models.Order;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/order")
public class OrderAPI {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrder(@QueryParam("orderID") int orderID,
                           @QueryParam("kitchen") boolean kitchen,
                           @QueryParam("service") boolean service) {

        //check orderID if not given, error or just everything today

        if (kitchen) {
            ArrayList<Order> orderList = fetchALaCarte(orderID);
        } else if (service) {

        }


        return null;
    }

    private ArrayList<Order> fetchALaCarte(int orderID) {
        String query = "SELECT purchased_a_la_carte.order_id, "
                + "a_la_carte_menu.*, "
                + "purchased_a_la_carte.antal "
                + "FROM purchased_a_la_carte "
                + "JOIN a_la_carte_menu ON purchased_a_la_carte.a_la_carte_id = a_la_carte_menu.a_la_carte_id "
                + "WHERE purchased_a_la_carte.order_id = ?";

        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<ALaCarteItem> aLaCarteItems = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();

             PreparedStatement preparedStatement = conn.prepareStatement(query)) {


            preparedStatement.setInt(1, orderID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                aLaCarteItems.add(new ALaCarteItem(rs.getInt("a_la_carte_id"), rs.getInt("price"), rs.getString("name"), rs.getString("type"), rs.getString("description")));

            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while fetching lunches.", e);
        }

        return orders;
    }
}
