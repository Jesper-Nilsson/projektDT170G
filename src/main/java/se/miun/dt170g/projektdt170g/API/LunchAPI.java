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

@Path("/lunch")
public class LunchAPI {
    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getLunch() {
        List<Lunch> lunches = new ArrayList<>();

        String query = "SELECT * FROM lunch_menu";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {


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
