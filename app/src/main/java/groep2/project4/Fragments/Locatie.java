package groep2.project4.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.datetimepicker.date.DatePickerDialog;
import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.TimePickerDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import groep2.project4.Data.DataProcessor;
import groep2.project4.Data.DataType;
import groep2.project4.R;

/**
 * Created by Dominic on 21-6-2016.
 */
public class Locatie extends Fragment implements DatePickerDialog.OnDateSetListener,OnMapReadyCallback {
    Context cont;
    public SupportMapFragment sMapFragment;
    public TextView textViewSelected;
    FragmentManager sFragmentManager;

    int minute_x = 0;
    int hour_x = 0;
    int hour_day = 0;
    int hour_month = 0;
    int hour_year = 0;


    Calendar calendar = Calendar.getInstance();

    Button reminderbutton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("Locatie.java", "onCreateView");
        cont = inflater.getContext();

        sMapFragment = SupportMapFragment.newInstance();
        sMapFragment.getMapAsync(this);
        return inflater.inflate(R.layout.locatie, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sFragmentManager = getChildFragmentManager();
        sFragmentManager.beginTransaction().replace(R.id.map, sMapFragment).commit();
        textViewSelected = (TextView) view.findViewById(R.id.textViewMarker);
        reminderbutton = (Button) view.findViewById(R.id.setReminderButton);
        reminderbutton.setVisibility(View.INVISIBLE);
        reminderbutton.setEnabled(false);

        reminderbutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                DatePickerFragment dateFragment = new DatePickerFragment();
                dateFragment.info = textViewSelected.getText().toString();
                dateFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        DataProcessor dataProcessor = new DataProcessor(cont, "trommels.csv");
        //dit is de "initialize" van de map. als de map is geladen, doe dit.
        List<DataType> data = dataProcessor.RetrieveInfo();

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.909424, 4.488258), 10f));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                reminderbutton.setVisibility(View.VISIBLE);
                reminderbutton.setEnabled(true);
                textViewSelected.setText(marker.getTitle());
                return false;
            }
        });

        for(DataType tromtrom:data){
            ArrayList<String> info = tromtrom.getInfo();
            Marker test = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(Double.parseDouble(info.get(1)), Double.parseDouble(info.get(2))))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trommelding))
                    .title(info.get(0))
                    .snippet("concept: distance"));
        }
    }
}


    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {

    }

    public android.app.FragmentManager getSupportFragmentManager() {
        return getActivity().getFragmentManager();
    }




//    public static class TimePickerFragment extends DialogFragment
//            implements android.app.TimePickerDialog.OnTimeSetListener {
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            // Use the current time as the default values for the picker
//            final android.icu.util.Calendar c = android.icu.util.Calendar.getInstance();
//            int hour = c.get(android.icu.util.Calendar.HOUR_OF_DAY);
//            int minute = c.get(android.icu.util.Calendar.MINUTE);
//
//            // Create a new instance of TimePickerDialog and return it
//            return new android.app.TimePickerDialog(getActivity(), this, hour, minute,
//                    DateFormat.is24HourFormat(getActivity()));
//        }
//        @Override
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//        }
//    }
//    public static class DatePickerFragment extends DialogFragment
//            implements android.app.DatePickerDialog.OnDateSetListener {
//        int year;
//        int month;
//        int day;
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            // Use the current date as the default date in the picker
//            final Calendar c = Calendar.getInstance();
//            year = c.get(Calendar.YEAR);
//            month = c.get(Calendar.MONTH);
//            day = c.get(Calendar.DAY_OF_MONTH);
//
//            // Create a new instance of DatePickerDialog and return it
//            return new android.app.DatePickerDialog(getActivity(), this, year, month, day);
//        }
//        @Override
//        public void onDateSet(DatePicker view, int year, int month, int day) {
//
//        }
//
//    }
}