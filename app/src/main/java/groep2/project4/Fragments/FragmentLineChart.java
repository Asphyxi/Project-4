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
import java.util.List;

import groep2.project4.Data.InformationRetriever;
import groep2.project4.Data.Result;
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
        lineChart.zoom(3,3,50,50);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Result> results = InformationRetriever.getPerMaand();

        ArrayList<Entry> entries = new ArrayList<>();

        for (Result result:results) {
            entries.add(new BarEntry(result.res, result.maand -1));
        }

        ArrayList<String> labels = new ArrayList<String>();
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

        LineDataSet lineDataSet1 = new LineDataSet(entries, "Stolen bicycles per month");
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
