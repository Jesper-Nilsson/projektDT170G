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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/a_la_carte")
public class DinnerMenu {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getItemsByType(@QueryParam("type") String type) {
        List<Dinner> dinners = new ArrayList<>();

        String query = "SELECT * FROM dinner_menu WHERE type = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, type); // Set the type parameter
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dinners.add(new Dinner(rs.getInt("dinner_id"), rs.getInt("price"), rs.getString("name"), rs.getString("type"), rs.getString("description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dinners); // Convert the list of items to JSON
    }
}
