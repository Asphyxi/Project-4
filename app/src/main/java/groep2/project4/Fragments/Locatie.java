package groep2.project4.Fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.datetimepicker.date.DatePickerDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Calendar;
import java.util.List;

import groep2.project4.AgendaActivity;
import groep2.project4.Data.DataProcessor;
import groep2.project4.Data.InformationRetriever;
import groep2.project4.Data.Result;
import groep2.project4.R;

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
//                DatePickerFragment dateFragment = new DatePickerFragment();
//                dateFragment.info = textViewSelected.getText().toString();
//                dateFragment.show(getSupportFragmentManager(), "datePicker");

                Intent intent = new Intent(getContext(), AgendaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
//        DataProcessor dataProcessor = new DataProcessor(cont, "trommels.csv");
//        dataProcessor.RetrieveInfo();
//
//        List<Result> data = InformationRetriever.getLocations(cont);


        googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(51.922,4.4613))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trommelding))
                    .title("poep")
                    .snippet("concept: distance"));



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

//        for(Result tromtrom:data){
//            Marker test = googleMap.addMarker(new MarkerOptions()
//                    .position(new LatLng(tromtrom.latit, tromtrom.longit))
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trommelding))
//                    .title(tromtrom.adres)
//                    .snippet("concept: distance"));
//        }
    }


    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {

    }

    public android.app.FragmentManager getSupportFragmentManager() {
        return getActivity().getFragmentManager();
    }
}