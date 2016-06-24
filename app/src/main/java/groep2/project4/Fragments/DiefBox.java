package groep2.project4.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import groep2.project4.R;

public class DiefBox extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final String[] deelgem = new String[] {"Charlois", "Delfshaven", "Feijenoord",
            "Hillegersberg Schiebroek", "Hoek van Holland", "Hoogvliet", "IJsselmonde",
            "Kralingen Crooswijk", "Noord", "Overschie", "Pernis", "Prins Alexander", "Centrum",
            "Rozenburg"};
    private Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.diefbox_layout,container,false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, deelgem);

        spinner = (Spinner)view.findViewById(R.id.diefboxspinner);
        spinner.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
