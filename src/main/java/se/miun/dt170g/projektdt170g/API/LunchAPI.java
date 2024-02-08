package se.miun.dt170g.projektdt170g.API;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing lunch menus.
 *
 * @GET Provides functionality to retrieve lunch menu information from the database,
 * with optional filtering by today's date or for the current week.
 */
@Path("/lunch")
public class LunchAPI {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    /**
     * Retrieves a list of lunch menu items, optionally filtered by today's date or the current week.
     * If both 'today' and 'week' parameters are provided, 'today' takes precedence.
     *
     * @param week  Flag to filter the lunch menu for the current week.
     * @param today Flag to filter the lunch menu for today's date.
     * @return A JSON string representation of the list of lunch menu items.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getLunch(@QueryParam("week") boolean week,
                           @QueryParam("today") boolean today) {
        if (week && today) {
            // If both parameters are provided, default to today, don't do this though, why would you?
            today = true; // redundant but for clarity in code
            week = false;
        }

        List<Lunch> lunches = fetchLunches(today, week);

        try (Jsonb jsonb = JsonbBuilder.create()) {
            return jsonb.toJson(lunches);
        } catch (Exception e) {
            throw new RuntimeException("Error converting lunches to JSON", e);
        }
    }

    private List<Lunch> fetchLunches(boolean today, boolean week) {
        List<Lunch> lunches = new ArrayList<>();
        String baseQuery = "SELECT * FROM lunch_menu";
        String dateCondition = "";
        String orderCondition = " ORDER BY date";
        String fullQuery;

        //constructing the full query based on query parameter
        if (today) {
            dateCondition = " WHERE date = ?";
        } else if (week) {
            dateCondition = " WHERE date >= ? AND date <= ?";
        }
        fullQuery = baseQuery + dateCondition + orderCondition;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(fullQuery)) {

            //binding the parameters
            if (today) {
                preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            } else if (week) {
                LocalDate startDate = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
                LocalDate endDate = startDate.plusDays(6);
                preparedStatement.setDate(1, Date.valueOf(startDate));
                preparedStatement.setDate(2, Date.valueOf(endDate));
            }

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                lunches.add(new Lunch(rs.getInt("lunch_id"), rs.getString("name"), rs.getString("description"), rs.getDate("date"), rs.getInt("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while fetching lunches.", e);
        }

        return lunches;
    }
}
