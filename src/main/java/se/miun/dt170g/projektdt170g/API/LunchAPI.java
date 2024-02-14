package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Path("/lunch")
public class LunchAPI {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLunch(@QueryParam("week") boolean week,
                             @QueryParam("today") boolean today) {
        LocalDate todayDate = LocalDate.now();
        List<LunchMenuEntity> lunchMenus;

        if (today) {
            lunchMenus = entityManager.createNamedQuery("LunchMenuEntity.findByDate", LunchMenuEntity.class)
                    .setParameter("date", Date.valueOf(todayDate))
                    .getResultList();
        } else if (week) {
            LocalDate startOfWeek = todayDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate endOfWeek = todayDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            lunchMenus = entityManager.createNamedQuery("LunchMenuEntity.findBetweenDates", LunchMenuEntity.class)
                    .setParameter("startDate", Date.valueOf(startOfWeek))
                    .setParameter("endDate", Date.valueOf(endOfWeek))
                    .getResultList();
        } else {
            // Define your fallback logic here, such as returning an empty list or all records
            lunchMenus = entityManager.createNamedQuery("LunchMenuEntity.findAll", LunchMenuEntity.class)
                    .getResultList(); // Assuming you have a named query to fetch all records
        }

        // Use the Response builder to return the list with proper status code
        return Response.ok(lunchMenus).build();
    }
}
