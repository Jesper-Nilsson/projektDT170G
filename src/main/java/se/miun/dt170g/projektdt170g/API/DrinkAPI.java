package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.Drink;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API endpoint class for managing a la carte menu items.
 * Allows retrieval of dinner menu items filtered by their type.
 */
@Path("/drinks")
public class DrinkAPI {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDrinks() {

        List<DrinksEntity> drinksEntities;
        List<Drink> drinks = new ArrayList<>();
        drinksEntities = entityManager.createNamedQuery("DrinksEntity.findAll", DrinksEntity.class).getResultList();
        for (DrinksEntity drink : drinksEntities){
            drinks.add(new Drink(drink));
        }
        return Response.ok(drinks).build();
    }
}

