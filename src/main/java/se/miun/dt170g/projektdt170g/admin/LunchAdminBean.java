package se.miun.dt170g.projektdt170g.admin;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g.projektdt170g.API.LunchAPI;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.net.URI;

@Named
@SessionScoped
public class LunchAdminBean implements Serializable {


    @Inject
    private LunchAPI lunchAPI;
    private LunchMenuEntity lunchMenuEntity = new LunchMenuEntity();
    private String action; // Define the action property

    private String message = "aa";



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
}
