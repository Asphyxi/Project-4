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
            labels.add("January");labels.add("February");labels.add("March");labels.add("April");labels.add("May");labels.add("June");labels.add("July");labels.add("August");labels.add("September");labels.add("October");labels.add("November");labels.add("December");

            ArrayList<BarEntry> group1 = new ArrayList<>();
            if(area == "Charlois") {
                group1.add(new BarEntry(4f, 0));                group1.add(new BarEntry(8f, 1));
                group1.add(new BarEntry(6f, 2));                group1.add(new BarEntry(12f, 3));
                group1.add(new BarEntry(18f, 4));                group1.add(new BarEntry(20f, 5));
                group1.add(new BarEntry(20f, 6));                group1.add(new BarEntry(20f, 7));
                group1.add(new BarEntry(20f, 8));                group1.add(new BarEntry(20f, 9));
                group1.add(new BarEntry(20f, 10));                group1.add(new BarEntry(20f, 11));
            }if(area == "Delfshaven"){
                group1.add(new BarEntry(4f, 0));                group1.add(new BarEntry(8f, 1));
                group1.add(new BarEntry(6f, 2));                group1.add(new BarEntry(12f, 3));
                group1.add(new BarEntry(18f, 4));                group1.add(new BarEntry(20f, 5));
                group1.add(new BarEntry(20f, 6));                group1.add(new BarEntry(20f, 7));
                group1.add(new BarEntry(20f, 8));                group1.add(new BarEntry(20f, 9));
                group1.add(new BarEntry(20f, 10));                group1.add(new BarEntry(20f, 11));
            }if(area == "Feijenoord"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Hillegersberg Schiebroek"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Hoek van Holland"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));           group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Hoogvliet"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "IJsselmonde"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Kralingen Crooswijk"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Noord"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Overschie"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Pernis"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));

            }if(area == "Prins Alexander"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Centrum"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }if(area == "Rozenburg"){
            group1.add(new BarEntry(4f, 0));            group1.add(new BarEntry(8f, 1));
            group1.add(new BarEntry(6f, 2));            group1.add(new BarEntry(12f, 3));
            group1.add(new BarEntry(18f, 4));            group1.add(new BarEntry(20f, 5));
            group1.add(new BarEntry(20f, 6));            group1.add(new BarEntry(20f, 7));
            group1.add(new BarEntry(20f, 8));            group1.add(new BarEntry(20f, 9));
            group1.add(new BarEntry(20f, 10));            group1.add(new BarEntry(20f, 11));
            }
                ArrayList<BarEntry> group2 = new ArrayList<>();
            if (area == "Charlois"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));               group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Delfshaven"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Feijenoord"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Hillegersberg Schiebroek"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Hoek van Holland"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Hoogvliet"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "IJsselmonde"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Kralingen Crooswijk"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Noord"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Overschie"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));                group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));                group2.add(new BarEntry(20f, 11));
            }else if(area == "Pernis"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));               group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));              group2.add(new BarEntry(20f, 11));
            }else if(area == "Prins Alexander"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));               group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));              group2.add(new BarEntry(20f, 11));
            }else if(area == "Centrum"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));               group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));              group2.add(new BarEntry(20f, 11));
            }else if(area == "Rozenburg"){
                group2.add(new BarEntry(6f, 0));                group2.add(new BarEntry(7f, 1));
                group2.add(new BarEntry(8f, 2));                group2.add(new BarEntry(12f, 3));
                group2.add(new BarEntry(15f, 4));               group2.add(new BarEntry(20f, 5));
                group2.add(new BarEntry(6f, 6));                group2.add(new BarEntry(7f, 7));
                group2.add(new BarEntry(8f, 8));                group2.add(new BarEntry(12f, 9));
                group2.add(new BarEntry(15f, 10));              group2.add(new BarEntry(20f, 11));
            }
        BarDataSet barDataSet1 = new BarDataSet(group1, "Group 1");
        barDataSet1.setColor(Color.GREEN); BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
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