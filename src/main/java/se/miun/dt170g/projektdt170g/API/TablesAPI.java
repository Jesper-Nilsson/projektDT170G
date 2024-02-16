package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.models.DrinksEntity;
import se.miun.dt170g.projektdt170g.models.TableSessionEntity;

import java.util.List;



/**
 * REST API endpoint class for managing tables.
 */
@Path("/tables")
public class TablesAPI {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTables() {

        List<TableSessionEntity> tables;
        tables = entityManager.createNamedQuery("TableSessionEntity.findAll", TableSessionEntity.class).getResultList();
        return Response.ok(tables).build();
    }
}

