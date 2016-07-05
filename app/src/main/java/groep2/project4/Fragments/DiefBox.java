package groep2.project4.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import groep2.project4.R;

public class DiefBox extends Fragment implements AdapterView.OnItemSelectedListener {
    Context cont;

    private static final String[] deelgem = new String[]{"Charlois", "Delfshaven", "Feijenoord",
            "Hillegersberg Schiebroek", "Hoek van Holland", "Hoogvliet", "IJsselmonde",
            "Kralingen Crooswijk", "Noord", "Overschie", "Pernis", "Prins Alexander", "Centrum",
            "Rozenburg"};
    private Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cont = inflater.getContext();
        View view = inflater.inflate(R.layout.diefbox_layout, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, deelgem);

        spinner = (Spinner) view.findViewById(R.id.diefboxspinner);
        spinner.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Fragment fragment;


        switch(i){
            case 1:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 2:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 3:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 4:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 5:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 6:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 7:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 8:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 9:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 10:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 11:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 12:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 13:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            case 14:
                fragment = new FragmentGroupedBarChart();
                showSelectedArea("Charlois");
                break;
            default:return;

        }
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.diefbox, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void showSelectedArea(String area) {
        Toast.makeText(cont, "You selected " + area,
                Toast.LENGTH_SHORT).show();
    }
}