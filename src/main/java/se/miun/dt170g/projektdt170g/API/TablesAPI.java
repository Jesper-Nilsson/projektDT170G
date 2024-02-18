package se.miun.dt170g.projektdt170g.API;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
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


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateDrink(@PathParam("id") int session_id, TableSessionEntity newTable) {
        // Find the existing table in the database
        TableSessionEntity existingTable = entityManager.find(TableSessionEntity.class, session_id);

        if (existingTable == null)
            return Response.status(Response.Status.NOT_FOUND).build(); // Table not found, return a 404

        // Update the existing table with the new information
        existingTable.setTableStatus(newTable.getTableStatus());

        return Response.ok().build();
    }
}

