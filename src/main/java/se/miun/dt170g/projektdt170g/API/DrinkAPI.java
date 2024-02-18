package se.miun.dt170g.projektdt170g.API;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.items.Drink;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import javax.sql.DataSource;
import java.sql.*;
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

        List<DrinksEntity> drinks;
        drinks = entityManager.createNamedQuery("DrinksEntity.findAll", DrinksEntity.class).getResultList();
        return Response.ok(drinks).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addDrink(DrinksEntity newDrink) {
        if (newDrink != null) {
            entityManager.persist(newDrink);
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}

