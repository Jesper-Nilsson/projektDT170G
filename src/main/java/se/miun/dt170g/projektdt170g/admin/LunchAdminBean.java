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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.net.URI;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;


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
    // Id of the selected lunch for update
    private Long selectedLunchId;



    // Temporary here for update lunch
    private String name;
    private String description;
    private LocalDate date;
    private int price;



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

    public void deleteLunch() {
        setMessage("borttagen");
        setAction("none");
        Response response = lunchAPI.deleteLunch(lunchMenuEntity.getLunchId());
    }


    /*
    public void updateLunch() {
        setMessage("uppdaterad");
        setAction("none");
        Response response = lunchAPI.updateLunch(lunchMenuEntity.getLunchId(), this.lunchMenuEntity);
    }
*/


    public String getLunchName() {
        return lunchMenuEntity.getName();
    }

    public void setLunchName(String lunchName) {
        lunchMenuEntity.setName(lunchName);
    }
    public LocalDate getLunchDate() {
        return lunchMenuEntity.getDate();
    }

    public void setLunchDate(LocalDate lunchDate) {
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








    // Temporary here
    public Long getSelectedLunchId() {
        return selectedLunchId;
    }

    public void setSelectedLunchId(Long selectedLunchId) {
        this.selectedLunchId = selectedLunchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    // Method to get all lunches from the database for the dropdown
    public List<LunchMenuEntity> getAllLunches() {
        return lunchAPI.getLunch(false,false,true);
    }


    // Loads the details of the selected lunch so the can be shown in the update form
    public void loadSelectedLunch() {
        this.lunchMenuEntity = lunchAPI.getLunch(selectedLunchId);
    }





}