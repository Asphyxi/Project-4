package groep2.project4;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.SupportMapFragment;

import groep2.project4.Data.DataProcessor;
import groep2.project4.Data.iLocalDatabase;
import groep2.project4.Fragments.FragmentDiefstal;
import groep2.project4.Fragments.TrommelFragment;
import groep2.project4.Fragments.LocationFragment;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener/*, OnMapReadyCallback*/ {

    static Context context;
    static iLocalDatabase db;
    MenuColorManager menucolormanager = new MenuColorManager();

    Fragment fragFietsTrommels = new TrommelFragment();
    Fragment fragDiefstallen = new FragmentDiefstal();
    Fragment fragLocatie = new LocationFragment();


    SupportMapFragment sMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Database gets prepared and all information is updated
        context = getApplicationContext();
        DBFactory factory = new DBFactory(context);
        db = factory.create();
        db.PrepareDB();

        //access the data
        DataProcessor dbTrommel = new DataProcessor(context, "trommels.csv");
        DataProcessor dbDiefstal = new DataProcessor(context, "diefstal.csv");
        dbTrommel.RetrieveInfo();
        dbDiefstal.RetrieveInfo();

        sMapFragment = SupportMapFragment.newInstance();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setItemTextColor(ColorStateList.valueOf(Color.DKGRAY));

        menucolormanager.HeadingCharts(navigationView.getMenu().findItem(R.id.categorie1),navigationView.getMenu().findItem(R.id.categorie2),navigationView.getMenu().findItem(R.id.categorie3));
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

        } else if (id == R.id.locatie) { fragment = fragLocatie;
            if(!sMapFragment.isAdded()) {
                sFragmentManager.beginTransaction().add(R.id.map, sMapFragment).commit();
            }else{sFragmentManager.beginTransaction().show(sMapFragment).commit();}

        } else {return false;}

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.drawer_start, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public static iLocalDatabase getDb() {
        return db;
    }
}
