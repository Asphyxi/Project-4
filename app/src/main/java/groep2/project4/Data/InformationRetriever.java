package groep2.project4.Data;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import groep2.project4.DrawerActivity;
import groep2.project4.MainActivity;

public class InformationRetriever {

    static LocalDB DB = DrawerActivity.getDb();

    public static List<Result> getLocations(Context context) {
        List<Result> resultlist = new ArrayList<>();

        DB.openDB();
        Cursor c = DB.thisDB.rawQuery("SELECT adres, longit, latit FROM fietstrommels", null);

        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                String adres = c.getString(c.getColumnIndex("adres"));
                Double longit = c.getDouble(c.getColumnIndex("longit"));
                Double latit = c.getDouble(c.getColumnIndex("latit"));
                resultlist.add(new Result(adres, longit, latit));
            } while (c.moveToNext());
        }
    c.close();
    DB.closeDB();
    return resultlist;
    }
}
