package groep2.project4.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

/**
 * Created by Dennis on 28-6-2016.
 */
public class TimePickerFragment extends DialogFragment
        implements android.app.TimePickerDialog.OnTimeSetListener {

    public String info;
    public int day;
    public int month;
    public int year;
    public int hour;
    public int minute;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final android.icu.util.Calendar c = android.icu.util.Calendar.getInstance();
        int hour = c.get(android.icu.util.Calendar.HOUR_OF_DAY);
        int minute = c.get(android.icu.util.Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new android.app.TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.hour = hourOfDay;
        this.minute = minute;
        makeReminder();
    }

    public void makeReminder(){
        pushAppointmentsToCalendar
                .pushAppointmentsToCalender(getActivity(),"Fiets Trommel Reminder", info,"",1,new GregorianCalendar(year + 1900, month, day, hour, minute, 0).getTimeInMillis(), false, false);
    }
}