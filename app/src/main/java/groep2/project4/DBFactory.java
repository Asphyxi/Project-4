package groep2.project4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import groep2.project4.Data.DataProcessor;
import groep2.project4.Data.ExternalDB;
import groep2.project4.Data.LocalDB;
import groep2.project4.Data.iLocalDatabase;

public class DBFactory {

    Context context;

    public DBFactory(Context context) {
        this.context = context;
    }
    
    public iLocalDatabase create() {
        iLocalDatabase database;
        Boolean externaldbworks = false;

        if (externaldbworks) { //Should only make a externaldb if there's an internet connection, however ExternalDB was never fully implemented due to time constraints
            database = new ExternalDB();
        } else {
            database = new LocalDB(context);
        }
        return database;
    }
}
