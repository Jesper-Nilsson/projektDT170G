package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.EventsEntity;

import java.time.LocalDate;
import java.util.List;

@Path("/events")
@Stateless
public class EventAPI {
    @PersistenceContext
    private EntityManager entityManager;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThreeNextEvents() {
        LocalDate today = LocalDate.now();

        List<EventsEntity> events = entityManager.createNamedQuery(EventsEntity.findAfterDate, EventsEntity.class)
                .setMaxResults(3)
                .setParameter("date",today)
                .getResultList();

        return Response.ok(events).build();
    }
}
