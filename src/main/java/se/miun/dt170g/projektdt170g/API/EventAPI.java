package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.EventsEntity;

import java.util.List;
import java.io.Serializable;

@Stateless
@Path("/events")
public class EventAPI implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvents() {
        List<EventsEntity> events = entityManager.createQuery("SELECT e FROM EventsEntity e", EventsEntity.class)
                .getResultList();
        return Response.ok(events).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventById(@PathParam("id") int id) {
        EventsEntity event = entityManager.find(EventsEntity.class, id);
        if (event != null) {
            return Response.ok(event).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Event not found").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvent(@PathParam("id") int id) {
        try {
            EventsEntity event = entityManager.find(EventsEntity.class, id);
            if (event != null) {
                entityManager.remove(event);
                return Response.ok().entity("Event deleted successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Event not found").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting event: " + e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEvent(EventsEntity event) {
        try {
            entityManager.persist(event);
            return Response.status(Response.Status.CREATED).entity(event).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error saving event: " + e.getMessage()).build();
        }
    }



}
