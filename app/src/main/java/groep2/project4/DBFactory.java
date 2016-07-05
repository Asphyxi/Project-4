package groep2.project4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import groep2.project4.Data.ExternalDB;
import groep2.project4.Data.LocalDB;
import groep2.project4.Data.iLocalDatabase;

public class DBFactory {

    //TODO: Add permissions for accessing the network state <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    
    public iLocalDatabase create(Context cont) {
        iLocalDatabase database;
        ConnectivityManager cm = (ConnectivityManager)cont.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork.getType()==ConnectivityManager.TYPE_WIFI) {
            database = new ExternalDB();
            database.PrepareDB();
        } else {
            database = new LocalDB(cont);
            database.PrepareDB();
        }
        return database;
    }
}
