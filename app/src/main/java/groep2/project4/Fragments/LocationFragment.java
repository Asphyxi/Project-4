package groep2.project4.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
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
import groep2.project4.Data.InformationRetriever;
import groep2.project4.Data.Result;
import groep2.project4.R;

public class LocationFragment extends Fragment implements DatePickerDialog.OnDateSetListener,OnMapReadyCallback {
    Context cont;
    public SupportMapFragment sMapFragment;
    public TextView textViewSelected;
    FragmentManager sFragmentManager;

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;

    GoogleMap googleMap;
    View view;
    GPSTracker mGPS;
    public static Marker selectedmarker;

    public static Marker savedmarker;

    SharedPreferences settings;
    SharedPreferences.Editor editor;

    Button reminderbutton;
    Button saveloc;
    Button delloc;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("LocationFragment.java", "onCreateView");
        cont = inflater.getContext();

        sMapFragment = SupportMapFragment.newInstance();
        sMapFragment.getMapAsync(this);



        settings = getContext().getSharedPreferences("group2.project4", 0);
        editor = settings.edit();

        int i = settings.getInt("executed", 0);
        editor.putInt("executed", i+1);
        editor.apply();

        mGPS = new GPSTracker(getContext());

        return inflater.inflate(R.layout.locatie, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        this.view = view;
        super.onViewCreated(view, savedInstanceState);
        sFragmentManager = getFragmentManager();
        sFragmentManager.beginTransaction().replace(R.id.maps, sMapFragment).commit();

        //layout stuff
        textViewSelected = (TextView) view.findViewById(R.id.textViewMarker);
        reminderbutton = (Button) view.findViewById(R.id.setReminderButton);
        reminderbutton.setVisibility(View.INVISIBLE);
        reminderbutton.setEnabled(false);
        saveloc = (Button) view.findViewById(R.id.saveloc);
        delloc = (Button) view.findViewById(R.id.delloc);

          reminderbutton.setOnClickListener(new View.OnClickListener() {
//
//
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AgendaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);}});

        //set the onclicks
        saveloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLocation();
            }
        });
        delloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delLocation();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //when the map is ready, draw all the markers.
        this.googleMap = googleMap;

        List<Result> results = InformationRetriever.getLocations();
        Log.e("4","2");

        for (Result result:results) { //Go through all results and add them to the map as markers
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(result.latit,result.longit))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trommelding))
                    .title(result.adres)
                    .snippet(""));
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.909424, 4.488258), 10f));
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
    @Override
    public boolean onMarkerClick(Marker marker) {
        selectedmarker = marker;
        reminderbutton.setVisibility(View.VISIBLE);
        reminderbutton.setEnabled(true);
        textViewSelected.setText(marker.getTitle());
        addsavedmarker();
        askLocPerms();

        return false;
            }
            });
        }


    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
    }

    public android.app.FragmentManager getSupportFragmentManager() {
        return getActivity().getFragmentManager();
    }
    public static Marker getSelectedMarker(){
        return selectedmarker;
    }

    public void askLocPerms(){ //asks for the location permissions
        if (ContextCompat.checkSelfPermission(this.getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        } else {
            //if permitted, setmylocation enabled
            googleMap.setMyLocationEnabled(true);
        }
    }

    public void saveLocation(){// saves current location
        mGPS.getLocation();
        editor.putFloat("latitude", (float) mGPS.getLatitude());
        editor.putFloat("longitude", (float) mGPS.getLongitude());
        editor.apply();
        addsavedmarker();
    }

    public void delLocation(){// sort of not really but does delete the marker (to the eye)
        editor.putFloat("latitude", 0);
        editor.putFloat("longitude", 0);
        editor.apply();
        savedmarker.setAlpha(0);
    }

    public void addsavedmarker(){//creates the "own location" marker
        savedmarker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(settings.getFloat("latitude", 0),settings.getFloat("longitude", 0)))
                .title("Opgeslagen Locatie")
                .snippet("concept: distance")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }


}