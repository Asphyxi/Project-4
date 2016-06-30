package groep2.project4.Fragments;

import android.Manifest;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

import static android.Manifest.permission.READ_CALENDAR;

/**
 * Created by Dennis on 28-6-2016.
 */
public class DatePickerFragment extends DialogFragment
        implements android.app.DatePickerDialog.OnDateSetListener {
    public String info;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new android.app.DatePickerDialog(getActivity(), this, year, month, day);
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        TimePickerFragment timeFragment = new TimePickerFragment();
        timeFragment.day = day;
        timeFragment.month = month;
        timeFragment.year = year;
        timeFragment.info = info;
        timeFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public FragmentManager getSupportFragmentManager() {
        return getActivity().getFragmentManager();
    }


}