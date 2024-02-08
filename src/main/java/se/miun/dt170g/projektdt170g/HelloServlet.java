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

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Resource(name = "jdbc/database")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT AGE, LENGTH FROM person")) {

            StringBuilder responseHtml = new StringBuilder("<html><body>");
            responseHtml.append("<h1>Personer i Databasen</h1>");
            responseHtml.append("<table border='1'>");
            responseHtml.append("<tr><th>Ålder</th><th>Längd</th></tr>");

            while (rs.next()) {
                int age = rs.getInt("AGE");
                float length = rs.getFloat("LENGTH");

                responseHtml.append("<tr>");
                responseHtml.append("<td>").append(age).append("</td>");
                responseHtml.append("<td>").append(length).append("</td>");
                responseHtml.append("</tr>");
            }

            responseHtml.append("</table>");

            // Form för att lägga till ny person
            responseHtml.append("<h2>Lägg till Ny Person</h2>");
            responseHtml.append("<form action='hello-servlet' method='post'>");
            responseHtml.append("Ålder: <input type='number' name='age' required />");
            responseHtml.append("Längd: <input type='number' name='length' required />");
            responseHtml.append("<input type='submit' name='action' value='Lägg Till Person'/>");
            responseHtml.append("</form>");

            // Form för att ta bort en person
            responseHtml.append("<h2>Ta bort Person</h2>");
            responseHtml.append("<form action='hello-servlet' method='post'>");
            responseHtml.append("Ålder för att ta bort: <input type='number' name='removeAge' required />");
            responseHtml.append("<input type='submit' name='action' value='Ta Bort Person'/>");
            responseHtml.append("</form>");

            responseHtml.append("</body></html>");

            response.getWriter().println(responseHtml.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Databasanslutning misslyckades: " + e.getMessage() + "</h1>");
            response.getWriter().println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if ("Lägg Till Person".equals(action)) {
            // Lägg till person
            addPerson(request);
        } else if ("Ta Bort Person".equals(action)) {
            // Ta bort person
            removePerson(request);
        }

        response.sendRedirect("hello-servlet");
    }

    private void addPerson(HttpServletRequest request) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            int age = Integer.parseInt(request.getParameter("age"));
            float length = Float.parseFloat(request.getParameter("length"));
            String sql = "INSERT INTO person (AGE, LENGTH) VALUES (" + age + ", " + length + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Fel vid tillägg av person: " + e.getMessage());
        }
    }

    private void removePerson(HttpServletRequest request) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            int removeAge = Integer.parseInt(request.getParameter("removeAge"));
            String sql = "DELETE FROM person WHERE AGE = " + removeAge;
            stmt.executeUpdate(sql);
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Fel vid borttagning av person: " + e.getMessage());
        }
    }
}
