package se.miun.dt170g.projektdt170g.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import se.miun.dt170g.projektdt170g.models.LunchMenuEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class Menue implements Serializable {

    private List<LunchMenuEntity> weeklyMenus = new ArrayList<>();

    public Menue() {
        // Example initialization with hardcoded values
        initializeSampleMenus();
    }

    private void initializeSampleMenus() {
        weeklyMenus.add(new LunchMenuEntity("Måndag", "Köttfärslimpa, gräddsås, kokt potatis, lingonsylt och gurka", LocalDate.now(), 100));
        weeklyMenus.add(new LunchMenuEntity("Tisdag", "Raggmunk, stekt fläsk och rårörda lingon", LocalDate.now().plusDays(1), 100));
        weeklyMenus.add(new LunchMenuEntity("Onsdag", "Flygande Jakob med ris", LocalDate.now().plusDays(2), 100));
        weeklyMenus.add(new LunchMenuEntity("Torsdag", "Potterstek med kokt potatis", LocalDate.now().plusDays(3), 100));
        weeklyMenus.add(new LunchMenuEntity("Fredag", "Barbequelaserad karré med ugnsrostad potatis", LocalDate.now().plusDays(4), 100));
    }


    // Getter for weeklyMenus
    public List<LunchMenuEntity> getWeeklyMenus() {
        return weeklyMenus;
    }
}
