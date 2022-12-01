package net.sourceforge.ganttproject.gui;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.ParentReference;
import com.google.api.services.drive.model.FileList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

/* class to demonstarte use of Drive files list API */
public class GoogleDriveAPI {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokensDrive";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/client_drive.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */

    public GoogleDriveAPI() throws IOException, GeneralSecurityException {
        System.out.println("ALELUIA!");
        //System.out.println(CREDENTIALS_FILE_PATH);
        NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        // Build a new authorized API client service.
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        //upload(service);
        //uploadBasic(service);
        insertFile(service, "DRIVE", "cenas", null, "text/plain", "C:/Users/bruno/Documents/CLINGO/Casamentos.txt");
    }
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {

        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println(currentPath);

        // Load client secrets.
        final java.io.File initialFile = new java.io.File(currentPath + CREDENTIALS_FILE_PATH);
        InputStream in = new java.io.DataInputStream(new java.io.FileInputStream(initialFile));
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + currentPath + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        credential.refreshToken();
        //returns an authorized Credential object.
        return credential;
    }

    public static void upload(Drive service) throws IOException, GeneralSecurityException {
       /*
        // Build a new authorized API client service.
        NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        // Build a new authorized API client service.
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    */
        /*
        // Upload file photo.jpg on drive.
        File fileMetadata = new File();
        fileMetadata.setName("Casamentos.txt");
        // File's content.
        java.io.File filePath = new java.io.File("C:/Users/bruno/Documents/CLINGO/Casamentos.txt");
        // Specify media type and file-path for file.
        FileContent mediaContent = new FileContent("text/plain", filePath);
        try {
            File file = service.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();
            System.out.println("File ID: " + file.getId());
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to upload file: " + e.getDetails());
            throw e;
        }*/
        /*
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        */
        // Print the names and IDs for up to 10 files.
    /*
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }*/
    }
    /*

    public static String uploadBasic(Drive service) throws IOException {
        // Upload file photo.jpg on drive.
        File fileMetadata = new File();
        fileMetadata.setName("Casamentos.txt");
        // File's content.
        java.io.File filePath = new java.io.File("C:/Users/bruno/Documents/CLINGO/Casamentos.txt");
        // Specify media type and file-path for file.
        FileContent mediaContent = new FileContent("text/plain", filePath);
        try {
            File file = service.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();
            System.out.println("File ID: " + file.getId());
            return file.getId();
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to upload file: " + e.getDetails());
            throw e;
        }
    }*/

    private static File insertFile(Drive service, String title, String description,
                                   String parentId, String mimeType, String filename) {
        // File's metadata.
        File body = new File();
        body.setTitle(title);
        body.setDescription(description);
        body.setMimeType(mimeType);

        // Set the parent folder.
        if (parentId != null && parentId.length() > 0) {
            body.setParents(
                    Arrays.asList(new ParentReference().setId(parentId)));
        }

        // File's content.
        java.io.File fileContent = new java.io.File(filename);
        FileContent mediaContent = new FileContent(mimeType, fileContent);
        try {
            File file = service.files().insert(body, mediaContent).execute();

            // Uncomment the following line to print the File ID.
            // System.out.println("File ID: " + file.getId());

            return file;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            return null;
        }
    }
}