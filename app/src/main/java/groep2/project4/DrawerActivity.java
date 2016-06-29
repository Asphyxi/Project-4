package groep2.project4;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.SupportMapFragment;

import groep2.project4.Fragments.FragmentBarChart;
import groep2.project4.Fragments.FragmentLineChart;
import groep2.project4.Fragments.FragmentPieChart;
import groep2.project4.Fragments.Kladblok;
import groep2.project4.Fragments.Locatie;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener/*, OnMapReadyCallback*/ {

    MenuColorManager menucolormanager = new MenuColorManager();

    Fragment fragFietsTrommels = new FragmentLineChart();
    Fragment fragDiefstallen = new FragmentBarChart();
    Fragment fragLocatie = new Locatie();
    Fragment fragRoute = new FragmentPieChart();
    Fragment fragKladblok = new Kladblok();


    FragmentManager mFragmentManager;

//    ActionBar.Tab Linechart, Piechart1, Piechart2;
//    android.app.Fragment fragmentTab1 = new FragmentTab1();
//    android.app.Fragment fragmentTab2 = new FragmentTab2();
//    android.app.Fragment fragmentTab3 = new FragmentTab3();

    SupportMapFragment sMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sMapFragment = SupportMapFragment.newInstance();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setItemTextColor(ColorStateList.valueOf(Color.DKGRAY));

        menucolormanager.HeadingCharts(navigationView.getMenu().findItem(R.id.categorie1),navigationView.getMenu().findItem(R.id.categorie2),navigationView.getMenu().findItem(R.id.categorie3), navigationView.getMenu().findItem(R.id.categorie4));

//        ActionBar actionBar = getActionBar();
//
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        Linechart = actionBar.newTab().setText("Tab1");
//        Piechart1 = actionBar.newTab().setText("Tab2");
//        Piechart2 = actionBar.newTab().setText("Tab3");
//
//        Linechart.setTabListener(new TabListener(fragmentTab1));
//        Piechart1.setTabListener(new TabListener(fragmentTab2));
//        Piechart2.setTabListener(new TabListener(fragmentTab3));
//
//        actionBar.addTab(Linechart);
//        actionBar.addTab(Piechart1);
//        actionBar.addTab(Piechart2);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        android.support.v4.app.FragmentManager sFragmentManager = getSupportFragmentManager();


        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;

        if(sMapFragment.isAdded()){
            sFragmentManager.beginTransaction().hide(sMapFragment).commit();
        }

        if (id == R.id.fietstrommels) {fragment = fragFietsTrommels;

        } else if (id == R.id.diefstallen) { fragment = fragDiefstallen;
//            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        } else if (id == R.id.locatie) { fragment = fragLocatie;
            if(!sMapFragment.isAdded()) {
                sFragmentManager.beginTransaction().add(R.id.map, sMapFragment).commit();
            }else{sFragmentManager.beginTransaction().show(sMapFragment).commit();}

        } else if (id == R.id.route) { fragment = fragRoute;

        } else if (id == R.id.kladblok) { fragment = fragKladblok;

        } else {return false;}

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.drawer_start, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }



//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        //dit is de "initialize" van de map. als de map is geladen, doe dit.
//        List<Trommel> data = CSVReader.FileReader(this, "trommels.csv");
//
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.909424, 4.488258),10f));
//
//        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                Log.e("marker", "clicked " + marker.getTitle());
//                return false;
//            }
//        });
//
//        for(Trommel tromtrom:data){
//            Marker test = googleMap.addMarker(new MarkerOptions()
//                    .position(new LatLng(tromtrom.longit, tromtrom.latit))
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trommelding))
//                    .title(tromtrom.Adres)
//                    .snippet("concept: distance"));
//        }
//    }
}
