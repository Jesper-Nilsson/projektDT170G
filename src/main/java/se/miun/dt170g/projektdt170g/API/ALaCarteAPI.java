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

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/a_la_carte")
public class ALaCarteAPI {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    /**
     * Retrieves a list of a la carte menu items filtered by the specified type.
     * This method responds to GET requests and produces a JSON representation of the items.
     *
     * @param type The type of dinner menu items to filter by (e.g., "förrätt", "huvudrätt", "efterrätt").
     * @return A JSON string representing a list of filtered a la carte menu items.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getItemsByType(@QueryParam("type") String type) {
        List<ALaCarteItem> aLaCarteItems = fetchItemsFromDatabase(type);

        try (Jsonb jsonb = JsonbBuilder.create()) {
            return jsonb.toJson(aLaCarteItems);
        } catch (Exception e) {
            throw new RuntimeException("Error converting a la carte items to JSON", e);
        }
    }

    /**
     * Fetches a list of a la carte menu items from the database filtered by the specified type.
     *
     * @param type The type of dinner menu items to filter by (e.g., "starter", "main", "dessert").
     * @return A list of ALaCarteItem objects representing the filtered a la carte menu items.
     */
    private List<ALaCarteItem> fetchItemsFromDatabase(String type) {
        List<ALaCarteItem> aLaCarteItems = new ArrayList<>();

        String query = "SELECT * FROM dinner_menu WHERE type = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, type); // Set the type parameter
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                aLaCarteItems.add(new ALaCarteItem(rs.getInt("dinner_id"), rs.getInt("price"), rs.getString("name"), rs.getString("type"), rs.getString("description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while fetching a la carte items.", e);
        }

        return aLaCarteItems;
    }
}
