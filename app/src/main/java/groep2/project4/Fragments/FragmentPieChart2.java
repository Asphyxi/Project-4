package groep2.project4.Fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;


import java.util.ArrayList;
import java.util.List;

import groep2.project4.Data.InformationRetriever;
import groep2.project4.Data.Result;
import groep2.project4.R;

/**
 * Created by Dominic on 27-6-2016.
 */
public class FragmentPieChart2 extends Fragment {
    private PieChart pieChart;
    private PieData pieData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_piechart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pieChart = (PieChart) view.findViewById(R.id.FragPiechart);
        pieChart.setData(pieData); //set pieData into chart
        pieChart.setDescription("Merken");
        pieChart.animateY(1500);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        Integer count = -1;

        List<Result> results = InformationRetriever.getPieChart().get(1);

        for (Result result:results){
            count++;
            entries.add(new Entry(result.res, count));
            labels.add(result.identifier);
        }

        PieDataSet dataSet = new PieDataSet(entries, "# of calls");

        pieData = new PieData(labels, dataSet);
        dataSet.setColors(My_Colours);

    }

    public static final int[] My_Colours = {
            Color.rgb(180, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120),
            Color.rgb(106, 150, 134), Color.rgb(53, 210, 209), Color.rgb(255, 80, 138),
            Color.rgb(254, 50, 7), Color.rgb(254, 200, 120), Color.rgb(106, 100, 134),
            Color.rgb(106, 200, 134), Color.rgb(5, 175, 254), Color.rgb(102, 51, 0)
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}