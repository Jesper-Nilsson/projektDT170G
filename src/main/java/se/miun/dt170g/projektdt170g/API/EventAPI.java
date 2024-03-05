package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g.projektdt170g.models.EventsEntity;
import se.miun.dt170g.projektdt170g.items.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Path("/events")
@Stateless
public class EventAPI {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getThreeNextEvents() {
        LocalDate today = LocalDate.now();


        List<EventsEntity> eventsEntities = entityManager.createNamedQuery(EventsEntity.findAfterDate, EventsEntity.class)
                .setMaxResults(3)
                .setParameter("date", today)
                .getResultList();

        return eventsEntities.stream().map(Event::new).collect(Collectors.toList());
    }
}
