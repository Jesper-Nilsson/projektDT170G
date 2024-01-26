package se.miun.dt170g.projektdt170g;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.annotation.Resource;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import javax.sql.DataSource;

// Koray Aman Arabzadeh

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Insert sample data
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            // Assuming the columns are AGE (INT) and LENGTH (FLOAT)
           // stmt.executeUpdate("INSERT INTO person (AGE, LENGTH) VALUES (30, 175.5), (25, 160.0)");

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Error inserting data: " + e.getMessage() + "</h1>");
            response.getWriter().println("</body></html>");
            return; // Stop further execution in case of error
        }

        // Retrieve and display data
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT AGE, LENGTH FROM person")) {

            StringBuilder responseHtml = new StringBuilder("<html><body>");
            responseHtml.append("<h1>Database Connection Successful</h1>");
            responseHtml.append("<table border='1'>");
            responseHtml.append("<tr><th>Age</th><th>Length (cm)</th></tr>");

            while (rs.next()) {
                int age = rs.getInt("AGE");
                float length = rs.getFloat("LENGTH");

                responseHtml.append("<tr>");
                responseHtml.append("<td>").append(age).append("</td>");
                responseHtml.append("<td>").append(length).append("</td>");
                responseHtml.append("</tr>");
            }

            responseHtml.append("</table>");
            responseHtml.append("</body></html>");

            response.getWriter().println(responseHtml.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Database Connection Failed: " + e.getMessage() + "</h1>");
            response.getWriter().println("</body></html>");
        }
    }
}