package se.miun.dt170g.projektdt170g.admin;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Named
@ViewScoped
public class FileUploadManagedBean implements Serializable {
    UploadedFile file;
    @Context
    private ServletContext context;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void dummyAction() {
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

}