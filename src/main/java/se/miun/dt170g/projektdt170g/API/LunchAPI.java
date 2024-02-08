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

@Path("/lunch")
public class LunchAPI {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getLunch(@QueryParam("week") boolean week,
                           @QueryParam("today") boolean today,
                           @QueryParam("limit") Integer limit) {
        List<Lunch> lunches = new ArrayList<>();

        String query = "SELECT * FROM lunch_menu";
        String dateCondition = "";


        if (today){
            LocalDate date = LocalDate.now();
            dateCondition = " WHERE date = ?";
        } else if (week) {
            LocalDate startDate = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
            LocalDate EndDate = startDate.plusDays(6);
            dateCondition = " WHERE date >= ? AND date <= ?";
        }

        query += dateCondition;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {


            if (today) {
                LocalDate date = LocalDate.now();
                pstmt.setDate(1, Date.valueOf(date)); // Bind the date for "today" condition
            } else if (week) {
                LocalDate startDate = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
                LocalDate endDate = startDate.plusDays(6);
                pstmt.setDate(1, Date.valueOf(startDate)); // Bind the start date for "week" condition
                pstmt.setDate(2, Date.valueOf(endDate)); // Bind the end date for "week" condition
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                lunches.add(new Lunch(rs.getInt("lunch_id"),  rs.getString("name"), rs.getString("description"), rs.getDate("date"), rs.getInt("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(lunches); // Convert the list of items to JSON
    }
}
