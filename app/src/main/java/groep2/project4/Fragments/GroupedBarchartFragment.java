package groep2.project4.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

import groep2.project4.Data.InformationRetriever;
import groep2.project4.Data.Result;
import groep2.project4.R;

public class GroupedBarchartFragment extends Fragment {

    private BarChart chart;
    private String area;

    public GroupedBarchartFragment(String area){this.area = area;}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_groupedbarchart,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chart = (BarChart) view.findViewById(R.id.FragGroupBarchart);
        chart.animateY(5000);
        chart.zoom(2,2,50,50);
    }
    @Override
    public void onResume() {
        super.onResume();

        chart.setData(getUpdatedChartData());
    }
    private BarData getUpdatedChartData() {

        Integer empty = 0;

        List<Result> trommels = InformationRetriever.getTrommels();
        List<Result> diefstallen = InformationRetriever.getDiefStallen();

        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        labels.add("August");
        labels.add("September");
        labels.add("October");
        labels.add("November");
        labels.add("December");

        ArrayList<BarEntry> group1 = new ArrayList<>();
        ArrayList<BarEntry> group2 = new ArrayList<>();
        Result legetrommel = new Result("", empty);

        Result trommelret = null;
        for (Result trommel:trommels) {
            if (trommel != null) {
                if (trommel.identifier.toLowerCase().equals(area.toLowerCase())) {
                    trommelret = trommel;
                }
            }
        }
        if (trommelret == null) {
            trommelret = legetrommel;
        }
        for (Result diefstal:diefstallen) {
            if (diefstal.deelgemeente.toLowerCase().equals(area.toLowerCase())) {
                group2.add(new BarEntry(diefstal.res,diefstal.maand-1));
                group1.add(new BarEntry(trommelret.res, diefstal.maand-1));
            }
        }

        BarDataSet barDataSet1 = new BarDataSet(group1, "Fietstrommels");
        barDataSet1.setColor(Color.GREEN); BarDataSet barDataSet2 = new BarDataSet(group2, "Fietsdiefstallen");
        barDataSet2.setColor(Color.RED); ArrayList<IBarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);
        return new BarData(labels, dataset);
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}