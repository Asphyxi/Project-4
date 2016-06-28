package groep2.project4;

/**
 * Created by Dominic on 28-6-2016.
 */
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.app.Activity;

import groep2.project4.Fragments.TabListener;

public class TabActivity extends Activity {
    // Declare Tab Variable
    ActionBar.Tab Linechart, Piechart1, Piechart2;
    Fragment fragmentTab1 = new FragmentTab1();
    Fragment fragmentTab2 = new FragmentTab2();
    Fragment fragmentTab3 = new FragmentTab3();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();

        // Hide Actionbar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide Actionbar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create Actionbar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        Linechart = actionBar.newTab().setText("Tab1");
        Piechart1 = actionBar.newTab().setText("Tab2");
        Piechart2 = actionBar.newTab().setText("Tab3");

        // Set Tab Listeners
        Linechart.setTabListener(new TabListener(fragmentTab1));
        Piechart1.setTabListener(new TabListener(fragmentTab2));
        Piechart2.setTabListener(new TabListener(fragmentTab3));

        // Add tabs to actionbar
        actionBar.addTab(Linechart);
        actionBar.addTab(Piechart1);
        actionBar.addTab(Piechart2);
    }
}