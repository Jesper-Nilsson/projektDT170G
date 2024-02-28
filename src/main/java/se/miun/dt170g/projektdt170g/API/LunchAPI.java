
package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Stateless
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

























    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLunch(LunchMenuEntity lunchMenu) {
        try {
            entityManager.persist(lunchMenu);
            return Response.status(Response.Status.CREATED).entity(lunchMenu).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error saving lunch menu: " + e.getMessage()).build();
        }
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLunch(@PathParam("id") int id, LunchMenuEntity updateEntity) {
        try {
            LunchMenuEntity lunchMenu = entityManager.find(LunchMenuEntity.class, id);
            if (lunchMenu == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Lunch menu item not found").build();
            }
            lunchMenu.setDate(updateEntity.getDate());
            lunchMenu.setName(updateEntity.getName());
            lunchMenu.setDescription(updateEntity.getDescription());
            lunchMenu.setPrice(updateEntity.getPrice());
            entityManager.merge(lunchMenu);
            return Response.ok(lunchMenu).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating lunch menu: " + e.getMessage()).build();
        }
    }


    @DELETE
    @Path("/{id}")
    public Response deleteLunch(@PathParam("id") int id) {
        try {
            LunchMenuEntity lunchMenu = entityManager.find(LunchMenuEntity.class, id);
            if (lunchMenu == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Lunch menu item not found").build();
            }
            entityManager.remove(lunchMenu);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting lunch menu: " + e.getMessage()).build();
        }
    }






}





/*
package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.util.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.io.Serializable;

@Stateless
@Path("/lunch")
public class LunchAPI implements Serializable{
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



    @DELETE
    @Path("/{id}")
    public Response deleteLunch(@PathParam("id") int id) {
        try {
            LunchMenuEntity lunchMenu = entityManager.find(LunchMenuEntity.class, id);
            if (lunchMenu != null) {
                entityManager.remove(lunchMenu);
                return Response.ok().entity("Lunch deleted successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Lunch not found").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting lunch: " + e.getMessage()).build();
        }
    }




    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLunch(LunchMenuEntity lunchMenu) {
        try {
            entityManager.persist(lunchMenu);
            return Response.status(Response.Status.CREATED).entity(lunchMenu).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error saving lunch menu: " + e.getMessage()).build();
        }
    }



}


 */


