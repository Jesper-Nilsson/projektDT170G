package se.miun.dt170g.projektdt170g.API;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g.projektdt170g.models.Drink;
import se.miun.dt170g.projektdt170g.models.Lunch;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/a_la_carte")
public class DrinkAPI {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDrinks() {

        List<Drink> drinks = fetchDrinks();

        try (Jsonb jsonb = JsonbBuilder.create()) {
            return jsonb.toJson(drinks);
        } catch (Exception e) {
            throw new RuntimeException("Error converting lunches to JSON", e);
        }
    }

    private List<Drink> fetchDrinks() {
        return null;
    }
}

