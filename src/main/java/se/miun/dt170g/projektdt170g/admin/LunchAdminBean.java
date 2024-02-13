package se.miun.dt170g.projektdt170g.admin;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.Date;
import java.util.logging.Logger;

@Named
@RequestScoped
public class LunchAdminBean  {

    private String lunchName;

    private String lunchDescription;
    private String action; // Define the action property
    private Date lunchDate;

    private int lunchPrice = 99;
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

    }


    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }
    public Date getLunchDate() {
        return lunchDate;
    }

    public void setLunchDate(Date lunchDate) {
        this.lunchDate = lunchDate;
    }

    public String getLunchDescription() {
        return lunchDescription;
    }

    public void setLunchDescription(String lunchDescription) {
        this.lunchDescription = lunchDescription;
    }

    public int getLunchPrice() {
        return lunchPrice;
    }

    public void setLunchPrice(int lunchPrice) {
        this.lunchPrice = lunchPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
