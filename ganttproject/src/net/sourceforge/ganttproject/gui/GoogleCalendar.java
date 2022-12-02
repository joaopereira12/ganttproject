package net.sourceforge.ganttproject.gui;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;
import net.sourceforge.ganttproject.task.Task;
import net.sourceforge.ganttproject.task.TaskManager;
import java.io.*;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.assertEquals;

/* Class to represent the  use of Google Calendar API with Events
*  This class was tested using assertions, in case of fail the GanttProject shows a log with the error */
public class GoogleCalendar {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    /**
     * Map to store the tasks created in the GanttProject associated with their
     * id in the Google Calendar
     */
    private static Map<String,Task> tasksByGoogleId;
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";


    public GoogleCalendar() {
        tasksByGoogleId = new HashMap<>();
    }

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {

        String currentPath = new java.io.File(".").getCanonicalPath();
        // Load client secrets.
        final File initialFile = new File(currentPath + CREDENTIALS_FILE_PATH);
        InputStream in = new DataInputStream(new FileInputStream(initialFile));
        if (in == null) {
            throw new FileNotFoundException(currentPath + CREDENTIALS_FILE_PATH);
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
        //returns an authorized Credential object.
        return credential;
    }

    /**
     * Creates a Google Calendar Event from a given GanttProject Task
     * @param service - Google Calendar
     * @param task - Task to be inserted in Google Calendar
     * @throws IOException
     * @throws ParseException
     */
    private static void addGoogleCalendar(Calendar service, Task task) throws IOException, ParseException {
        String name = task.getName();
        String dateInit = switchDateFormat(task.getStart().toString());
        String dateEnd = switchDateFormat(task.getEnd().toString());

        Event event = new Event()
                .setSummary(name);

        DateTime startDateTime = new DateTime(dateInit +"T00:00:00-00:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Europe/Lisbon");
        event.setStart(start);

        DateTime endDateTime = new DateTime(dateEnd + "T00:00:00-00:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Europe/Lisbon");
        event.setEnd(end);

        EventReminder[] reminderOverrides = new EventReminder[]{
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));

        event.setReminders(reminders);

        String calendarId = "primary";
        event = service.events().insert(calendarId, event).execute();
        tasksByGoogleId.put(event.getId(), task);
        System.out.printf("Event created: %s\n", event.getHtmlLink());

        assert(tasksByGoogleId.containsKey(event.getId()) == true);
        assert(service.events().get(calendarId, event.getId()).execute() != null);
    }

    /**
     * Switch date format in order to insert the event in the Google Calendar
     * @param date - to switch format
     * @return date with new format
     * @throws ParseException
     */
    private static String switchDateFormat(String date) throws ParseException {
        SimpleDateFormat date1=new SimpleDateFormat("dd-MM-yyyy");
        Date d = date1.parse(date);
        date1.applyPattern("yyyy-MM-dd");

        return date1.format(d);
    }

    /**
     * Puts all GanttProject tasks in Google Calendar Events
     * @param taskManager - has access to the list with all GanttProject tasks
     * @throws IOException
     * @throws GeneralSecurityException
     * @throws ParseException
     */
    public static void listEvents(TaskManager taskManager) throws IOException, GeneralSecurityException, ParseException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        // List the next 100 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        String calendarId = "primary";
        Events events = service.events().list(calendarId)
                .setMaxResults(100)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            for (Event event : items) {
                // if the task was deleted from GanttProject then its Google Calendar must also be deleted
              if(!tasksByGoogleId.containsKey(event.getId())) {
                  String eventId = event.getId();
                  service.events().delete(calendarId, eventId).execute();

                  assert(tasksByGoogleId.containsKey(eventId) == false);
              }
            }
        }

        Task[] currentTasks = taskManager.getTasks();
        for (Task task : currentTasks) {
            addGoogleCalendar(service,task);
        }
    }
}