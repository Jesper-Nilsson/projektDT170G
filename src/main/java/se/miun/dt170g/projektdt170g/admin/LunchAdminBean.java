package se.miun.dt170g.projektdt170g.admin;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.LunchAPI;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.net.URI;
import jakarta.persistence.PersistenceContext;

@Named
@SessionScoped
public class LunchAdminBean implements Serializable {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Inject
    private LunchAPI lunchAPI;

    private LunchMenuEntity lunchMenuEntity = new LunchMenuEntity();
    private String action; // Define the action property

    private String message = "aa";
    private Long lunchIdToDelete;


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void addLunch(){
        // call api post lunch
        setMessage("tillagd");
        setAction("none");
        Response response = lunchAPI.addLunch(lunchMenuEntity);
    }

    public void updateLunch() {
        setMessage("uppdaterad");
        setAction("none");
        //Response response = lunchAPI.updateLunch(lunchMenuEntity);
    }

    public void deleteLunch(Long lunchId) {
        setMessage("borttagen");
        Response response = lunchAPI.deleteLunch(lunchId);

        // Refresh the list of lunches or handle the UI update
    }

    public String getLunchName() {
        return lunchMenuEntity.getName();
    }

    public void setLunchName(String lunchName) {
        lunchMenuEntity.setName(lunchName);
    }
    public Date getLunchDate() {
        return lunchMenuEntity.getDate();
    }

    public void setLunchDate(Date lunchDate) {
        lunchMenuEntity.setDate(lunchDate);
    }

    public String getLunchDescription() {
        return lunchMenuEntity.getDescription();
    }

    public void setLunchDescription(String lunchDescription) {
        lunchMenuEntity.setDescription(lunchDescription);
    }

    public int getLunchPrice() {
        return lunchMenuEntity.getPrice();
    }

    public void setLunchPrice(int lunchPrice) {
        lunchMenuEntity.setPrice(lunchPrice);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getLunchIdToDelete() {
        return lunchIdToDelete;
    }

    public void setLunchIdToDelete(Long lunchIdToDelete) {
        this.lunchIdToDelete = lunchIdToDelete;
    }

    public LunchMenuEntity getLunchMenuEntity() {
        return lunchMenuEntity;
    }

    public void setLunchMenuEntity(LunchMenuEntity lunchMenuEntity) {
        this.lunchMenuEntity = lunchMenuEntity;
    }


    // Method to delete lunch
    public void deleteLunch() {
        if (lunchIdToDelete == null || lunchIdToDelete <= 0) {
            message = "Invalid lunch ID";
            return;
        }


        try {
            Response response = lunchAPI.deleteLunch(lunchIdToDelete);
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                message = "Lunch deleted successfully";
                // Logic to refresh the lunch list can be added here if needed
            } else {
                message = "Failed to delete lunch: " + response.getStatusInfo().getReasonPhrase();
            }
        } catch (Exception e) {
            message = "Error during deletion: " + e.getMessage();
            // Log the exception and handle any rollback if necessary
        }
        // Reset the ID to delete after the operation
        lunchIdToDelete = null;
    }


    // Method to get all lunches from the database for the dropdown
    public List<LunchMenuEntity> getAllLunches() {
        return entityManager.createNamedQuery("LunchMenuEntity.findAll", LunchMenuEntity.class)
                .getResultList();
    }

}