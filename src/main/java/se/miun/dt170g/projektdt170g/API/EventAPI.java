package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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
    public List<EventsEntity> getThreeNextEvents() {
        LocalDate today = LocalDate.now();
        return entityManager.createNamedQuery(EventsEntity.findAfterDate, EventsEntity.class)
                .setParameter("date", today)
                .setMaxResults(3)
                .getResultList();
    }
}
