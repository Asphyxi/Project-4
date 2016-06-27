package groep2.project4.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

import java.util.List;

import groep2.project4.CSVReader;
import groep2.project4.DrawerActivity;
import groep2.project4.R;
import groep2.project4.Trommel;

/**
 * Created by Dominic on 21-6-2016.
 */
public class Locatie extends Fragment implements OnMapReadyCallback {
    Context cont;
    public SupportMapFragment sMapFragment;
    public TextView textViewSelected;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.e("Locatie.java", "onCreateView");
        cont = inflater.getContext();


        sMapFragment = SupportMapFragment.newInstance();
        sMapFragment.getMapAsync(this);
        return inflater.inflate(R.layout.locatie,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManager sFragmentManager = getChildFragmentManager();
        sFragmentManager.beginTransaction().replace(R.id.map, sMapFragment).commit();
        textViewSelected = (TextView) view.findViewById(R.id.textViewMarker);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //dit is de "initialize" van de map. als de map is geladen, doe dit.
        List<Trommel> data = CSVReader.FileReader(cont, "trommels.csv");

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.909424, 4.488258),10f));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                textViewSelected.setText(marker.getTitle());
                return false;
            }
        });

        for(Trommel tromtrom:data){
            Marker test = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(tromtrom.longit, tromtrom.latit))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trommelding))
                    .title(tromtrom.Adres)
                    .snippet("concept: distance"));
        }
    }
}


