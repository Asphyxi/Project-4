package groep2.project4.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Dennis on 28-6-2016.
 */
public class pushAppointmentsToCalendar {
    public static long pushAppointmentsToCalender(Activity curActivity, String title, String addInfo, String place, int status, long startDate, boolean needReminder, boolean needMailService,String... permissie) {
        /***************** Event: note(without alert) *******************/
        boolean permissions = true;
        for (String p : permissie) {
            permissions = permissions && ContextCompat.checkSelfPermission(curActivity, p) == 0;
        }
        if(!permissions){
        ActivityCompat.requestPermissions(curActivity,permissie,42);}



        //geen idee wat 42 is


        String eventUriString = "content://com.android.calendar/events";
        ContentValues eventValues = new ContentValues();

        eventValues.put("calendar_id", 1); // id, We need to choose from our mobile. for primary its 1
        eventValues.put("title", title);
        eventValues.put("description", addInfo);
        eventValues.put("eventLocation", place);

        long endDate = startDate + 1000 * 60 * 60; // For next 1hr

        eventValues.put("dtstart", startDate);
        eventValues.put("dtend", endDate);

        eventValues.put("allDay", 0); //If it is bithday alarm or such kind (which should remind me for whole day) 0 for false, 1 for true
        eventValues.put("eventStatus", status); // This information is sufficient for most entries tentative (0), confirmed (1) or canceled (2):
        eventValues.put("eventTimezone", "UTC/GMT +2:00");
   /*Comment below visibility and transparency  column to avoid java.lang.IllegalArgumentException column visibility is invalid error */

    /*eventValues.put("visibility", 3); // visibility to default (0),
                                        // confidential (1), private
                                        // (2), or public (3):
    eventValues.put("transparency", 0); // You can control whether
                                        // an event consumes time
                                        // opaque (0) or transparent
                                        // (1).
      */
        eventValues.put("hasAlarm", 1); // 0 for false, 1 for true

        Uri eventUri = curActivity.getApplicationContext().getContentResolver().insert(Uri.parse(eventUriString), eventValues);
        long eventID = Long.parseLong(eventUri.getLastPathSegment());

        if (needReminder) {
            /***************** Event: Reminder(with alert) Adding reminder to event *******************/

            String reminderUriString = "content://com.android.calendar/reminders";

            ContentValues reminderValues = new ContentValues();

            reminderValues.put("event_id", eventID);
            reminderValues.put("minutes", 5); // Default value of the system. Minutes is an integer
            reminderValues.put("method", 1); // Alert Methods: Default(0), Alert(1), Email(2), SMS(3)

            Uri reminderUri = curActivity.getApplicationContext().getContentResolver().insert(Uri.parse(reminderUriString), reminderValues);
        }

        /***************** Event: Meeting(without alert) Adding Attendies to the meeting *******************/

        if (needMailService) {
            String attendeuesesUriString = "content://com.android.calendar/attendees";

            /********
             * To add multiple attendees need to insert ContentValues multiple
             * times
             ***********/
            ContentValues attendeesValues = new ContentValues();

            attendeesValues.put("event_id", eventID);
            attendeesValues.put("attendeeName", "xxxxx");           // Attendees name
            attendeesValues.put("attendeeEmail", "yyyy@gmail.com"); // Attendee E-mail id

            attendeesValues.put("attendeeRelationship", 0); // Relationship_Attendee(1),
                                                            // Relationship_None(0),
                                                            // Organizer(2),
                                                            // Performer(3),
                                                            // Speaker(4)

            attendeesValues.put("attendeeType", 0); // None(0), Optional(1),
                                                    // Required(2), Resource(3)

            attendeesValues.put("attendeeStatus", 0);   // NOne(0), Accepted(1),
                                                        // Decline(2),
                                                        // Invited(3),
                                                        // Tentative(4)

            Uri attendeuesesUri = curActivity.getApplicationContext().getContentResolver().insert(Uri.parse(attendeuesesUriString), attendeesValues);
        }

        return eventID;

    }

}
