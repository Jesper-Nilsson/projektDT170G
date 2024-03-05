
package se.miun.dt170g.projektdt170g.admin;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.View;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import se.miun.dt170g.projektdt170g.API.ALaCarteAPI;
import se.miun.dt170g.projektdt170g.API.EventAPI;
import se.miun.dt170g.projektdt170g.items.Event;
import jakarta.servlet.http.Part;
import jakarta.ws.rs.core.Response;

@Named
@ViewScoped
public class EventAdminBean implements Serializable {

    @Context
    private ServletContext context;

    private Event event = new Event();


    private String temporaryFileName;

    private String message = "aa";

    private int selectedEventId;

    private int eventIdToDelete;
    private String action; // Define the action property

    @Inject
    private EventAPI eventAPI;
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEventName() {
        return event.getName();
    }

    public void setEventName(String eventName) {
        this.event.setName(eventName);
    }

    public String getEventDescription() {
        return event.getDescription();
    }

    public void setEventDescription(String eventDescription) {
        this.event.setDescription(eventDescription);
    }

    public int getEventPrice() {
        return event.getPrice();
    }

    public void setEventPrice(int eventPrice) {
        this.event.setPrice(eventPrice);
    }

    public LocalDate getEventDate() {
        return event.getDate();
    }
    public void setEventDate(LocalDate eventDate) {
        this.event.setDate(eventDate);
    }

    public int getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(int selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public int getEventIdToDelete() {
        return eventIdToDelete;
    }

    public void setEventIdToDelete(int getIdToDelete) {
        this.eventIdToDelete = getIdToDelete;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Event> getAllEvents() {
        return eventAPI.getComingEvents();
    }


    public void addEvent(){
        setMessage("tillagd");
        setAction("none");
        eventAPI.addEvent(this.event);
    }

    public void deleteEvent() {
        setMessage("borttagen");
        setAction("none");
        Response response = eventAPI.deleteEvent(this.eventIdToDelete);

    }

    public void updateEvent() {
        setMessage("uppdaterad");
        setAction("none");
        Response response = eventAPI.updateEvent(selectedEventId,event);
    }



    private String saveFile(Part file) throws IOException {
        // Check if the file part has a valid file name
        String fileName = getFileName(file);
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IOException("Cannot save upload; file name is invalid.");
        }

        // Define path where the images should be saved
        String basePath = "/resources/uploads/";
        String fileSavePath = basePath + fileName;

        // Create a File object with the full path
        File outputFile = new File(fileSavePath);

        // Create parent directories if they don't exist
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        // Copy the file content to the new location
        try (InputStream input = file.getInputStream()) {
            Files.copy(input, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        // You might want to return a relative path or a URL that can be used to access the file
        // For this example, the absolute path is returned
        return fileSavePath;
    }

    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null; // Or you could throw an exception or return a default name
    }

    public void loadSelectedEvent() {
        this.event = eventAPI.getEventById(selectedEventId);
        System.out.println("hej");

    }

    public void getHandleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();

        // Assuming 'context' is accessible here; if not, you'll need to obtain it.
        String directoryPath = context.getInitParameter("eventImagesDirectory");

        // Generate a unique file name. This could be based on a database ID, timestamp, etc.
        // For this example, I'll use a simple timestamp approach.
        String fileName = System.currentTimeMillis() + ".jpeg"; // Consider a more robust approach for production.

        File outputFile = new File(directoryPath, fileName);

        try (InputStream input = file.getInputStream()) {
            // Ensure directory exists.
            new File(directoryPath).mkdirs();

            // Copy file to the target directory.
            Files.copy(input, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Log success or further process the file as needed.
            System.out.println("Uploaded file successfully saved as " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            // Handle exceptions (e.g., logging, throwing a runtime exception)
            e.printStackTrace();
            throw new WebApplicationException("Error saving uploaded file", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }


    // Getter and setter for the action property

}
