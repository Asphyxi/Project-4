package groep2.project4.Fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import groep2.project4.R;

/**
 * Created by Dominic on 27-6-2016.
 */
public class FragmentLineChart extends Fragment {

    private LineData data;

    public FragmentLineChart(){}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LineChart lineChart = (LineChart)view.findViewById(R.id.FragLinechart);
        lineChart.setData(data);
        lineChart.animateY(5000);
        lineChart.zoom(2,2,50,50);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(22f, 5));
        entries.add(new BarEntry(26f, 6));
        entries.add(new BarEntry(29f, 7));


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");


        ArrayList<Entry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 0));
        group1.add(new BarEntry(8f, 1));
        group1.add(new BarEntry(6f, 2));
        group1.add(new BarEntry(12f, 3));
        group1.add(new BarEntry(18f, 4));
        group1.add(new BarEntry(9f, 5));

        LineDataSet lineDataSet1 = new LineDataSet(group1, "Stolen bicycles per month");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        lineDataSet1.setColor(Color.GREEN);
        lineDataSet1.setDrawFilled(true);



        ArrayList<ILineDataSet> dataset = new ArrayList<>();
        dataset.add(lineDataSet1);


        data = new LineData(labels, dataset);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_linechart,container,false);
    }
}
