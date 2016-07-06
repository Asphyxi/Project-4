package groep2.project4.Fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
        List<Result> results = InformationRetriever.getTop5();

        ArrayList<BarEntry> entries = new ArrayList<>();
        Integer count = -1;
        ArrayList<String> labels = new ArrayList<>();

        for (Result result:results) {
            count++;
            entries.add(new BarEntry(result.res, count));
            labels.add(result.identifier);
        }

        BarDataSet barDataSet1 = new BarDataSet(entries, "Trommels");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColor(Color.GREEN);

        ArrayList<IBarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);

        data=new BarData(labels, barDataSet1);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_barchart,container,false);
    }
}
