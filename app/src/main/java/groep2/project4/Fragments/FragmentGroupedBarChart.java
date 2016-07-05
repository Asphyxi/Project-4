package groep2.project4.Fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Objects;

import groep2.project4.R;

/**
 * Created by Dominic on 27-6-2016.
 */
public class FragmentGroupedBarChart extends Fragment {

    private BarChart chart;
    private String area;

    public FragmentGroupedBarChart(String area){this.area = area;}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ArrayList<BarEntry> entries = new ArrayList<>();
//        entries.add(new BarEntry(4f, 1));
//        entries.add(new BarEntry(8f, 2));
//        entries.add(new BarEntry(6f, 3));
//        entries.add(new BarEntry(12f, 4));
//        entries.add(new BarEntry(18f, 5));
//        entries.add(new BarEntry(22f, 6));
//        entries.add(new BarEntry(26f, 7));
//        entries.add(new BarEntry(29f, 8));

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

            ArrayList<String> labels = new ArrayList<>();
            labels.add("January");
            labels.add("February");
            labels.add("March");
            labels.add("April");
            labels.add("May");
            labels.add("June");

            ArrayList<BarEntry> group1 = new ArrayList<>();
        if(area == "Charlois") {
            group1.add(new BarEntry(4f, 0));
            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));
            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));
            group1.add(new BarEntry(20f, 5));
        }if(area == "Delfshaven"){

        }
            ArrayList<BarEntry> group2 = new ArrayList<>();
        if (area == "Charlois"){
            group2.add(new BarEntry(6f, 0));
            group2.add(new BarEntry(7f, 1));
            group2.add(new BarEntry(8f, 2));
            group2.add(new BarEntry(12f, 3));
            group2.add(new BarEntry(15f, 4));
            group2.add(new BarEntry(20f, 5));
        }
        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColor(Color.GREEN);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
        barDataSet2.setColor(Color.RED);

        ArrayList<IBarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);


        return new BarData(labels, dataset);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
