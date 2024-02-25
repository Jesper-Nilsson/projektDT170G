package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.ALaCarteItem;
import se.miun.dt170g.projektdt170g.models.ALaCarteMenuEntity;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/a_la_carte")
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

}
