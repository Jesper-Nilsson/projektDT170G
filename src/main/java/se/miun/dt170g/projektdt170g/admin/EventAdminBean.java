
package se.miun.dt170g.projektdt170g.admin;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import jakarta.servlet.http.Part;

@Named
@RequestScoped
public class EventAdminBean {
    private Part uploadedFile;
    private String eventName;
    private String eventDescription;
    private Date eventDate;
    private String imageUrl;

    // Properties specific to other actions
    private Long eventIdToDelete;
    private String action; // Define the action property
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    // Other properties and methods...

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getEventIdToDelete() {
        return eventIdToDelete;
    }

    public void setEventIdToDelete(Long eventIdToDelete) {
        this.eventIdToDelete = eventIdToDelete;
    }

    public void addEvent() {
        if (uploadedFile != null) {
            try {
                String fileName = saveFile(uploadedFile);
                setImageUrl(fileName);
            }
            catch (IOException e) {
                // Handle file save error
            }
        }
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


    // Getter and setter for the action property

}
