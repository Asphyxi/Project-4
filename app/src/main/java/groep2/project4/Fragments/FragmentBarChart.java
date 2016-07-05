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

import groep2.project4.R;

/**
 * Created by Dominic on 27-6-2016.
 */
public class FragmentBarChart extends Fragment {

    private BarData data;

    public FragmentBarChart(){}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BarChart barChart = (BarChart)view.findViewById(R.id.Barchart);
        barChart.setData(data);
        barChart.animateY(5000);
        barChart.zoom(2,2,50,50);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 1));
        entries.add(new BarEntry(8f, 2));
        entries.add(new BarEntry(6f, 3));
        entries.add(new BarEntry(12f, 4));
        entries.add(new BarEntry(18f, 5));
        entries.add(new BarEntry(22f, 6));
        entries.add(new BarEntry(26f, 7));
        entries.add(new BarEntry(29f, 8));


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");


        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 1));
        group1.add(new BarEntry(8f, 2));
        group1.add(new BarEntry(6f, 3));
        group1.add(new BarEntry(12f, 4));
        group1.add(new BarEntry(18f, 5));
        group1.add(new BarEntry(9f, 6));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColor(Color.GREEN);



        ArrayList<IBarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);



        data=new BarData(labels, dataset);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_barchart,container,false);
    }
}
