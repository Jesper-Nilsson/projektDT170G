package se.miun.dt170g.projektdt170g.API;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.models.ALaCarteMenuEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/a_la_carte")
@Stateless
public class ALaCarteAPI {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves a list of a la carte menu items filtered by the specified type.
     * This method responds to GET requests and produces a JSON representation of the items.
     *
     * @param type The type of dinner menu items to filter by (e.g., "förrätt", "huvudrätt", "efterrätt").
     * @return A JSON string representing a list of filtered a la carte menu items.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsByType(@QueryParam("type") String type) {
        List<ALaCarteMenuEntity> aLaCarteItems = new ArrayList<>();
        List<ALaCarteItem> foods = new ArrayList<>();
        String test = "ett test";
        if (type != null) {
            aLaCarteItems = entityManager.createNamedQuery(ALaCarteMenuEntity.findByType, ALaCarteMenuEntity.class).setParameter("type",type).getResultList();
        }else {
            aLaCarteItems = entityManager.createNamedQuery(ALaCarteMenuEntity.findAll,ALaCarteMenuEntity.class).getResultList();
        }
        for (ALaCarteMenuEntity aLaCarteMenuEntity : aLaCarteItems){
            foods.add(new ALaCarteItem(aLaCarteMenuEntity));
        }


        return Response.ok(foods).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@PathParam("id") int id) {
        ALaCarteMenuEntity item = entityManager.find(ALaCarteMenuEntity.class, id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Item not found").build();
        }
        ALaCarteItem food = new ALaCarteItem(item);
        return Response.ok(food).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(ALaCarteMenuEntity item) {
        try {
            entityManager.persist(item);
            return Response.status(Response.Status.CREATED).entity(item).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error creating item: " + e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateItem(@QueryParam("id") int id, ALaCarteMenuEntity itemUpdate) {
        try {
            ALaCarteMenuEntity item = entityManager.find(ALaCarteMenuEntity.class, id);
            if (item == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Item not found").build();
            }
            item.setName(itemUpdate.getName());
            item.setType(itemUpdate.getType());
            item.setDescription(itemUpdate.getDescription());
            item.setPrice(itemUpdate.getPrice());
            entityManager.merge(item);
            return Response.ok(item).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating item: " + e.getMessage()).build();
        }
    }
    @DELETE
    public Response deleteItem(@QueryParam("id") int id) {
        try {
            ALaCarteMenuEntity item = entityManager.find(ALaCarteMenuEntity.class, id);
            if (item == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Item not found").build();
            }
            entityManager.remove(item);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting item: " + e.getMessage()).build();
        }
    }



}
