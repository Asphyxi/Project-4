package groep2.project4.Data;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import groep2.project4.DrawerActivity;

public class InformationRetriever {

    static LocalDB DB = DrawerActivity.getDb();

    public static List<List<Result>> getDiefBox() {
        List<Result> boxlist = new ArrayList<>();
        List<Result> dieflist = new ArrayList<>();

        return null;
    }

    public static List<Result> getPerMaand() {
        List<Result> resultlist = new ArrayList<>();

        DB.openDB();
        Cursor c = DB.thisDB.rawQuery("SELECT maand, COUNT(maand) as res\n" +
                "FROM fietsdiefstallen\n" +
                "WHERE maand <> '' \n" +
                "GROUP BY maand\n" +
                "ORDER BY maand DESC;",null);
        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                Integer maand = c.getInt(c.getColumnIndex("maand"));
                Integer res = c.getInt(c.getColumnIndex("res"));
                resultlist.add(new Result(maand, res));
            } while (c.moveToNext());
        }
        c.close();
        DB.closeDB();
        return resultlist;
    }

    public static List<Result> getTop5() {
        List<Result> resultlist = new ArrayList<>();

        DB.openDB();
        Cursor c = DB.thisDB.rawQuery("SELECT deelgemeente, COUNT(deelgemeente) AS res FROM fietstrommels\n" +
                "WHERE deelgemeente <> '' \n" +
                "GROUP BY deelgemeente\n" +
                "ORDER BY res DESC\n" +
                "LIMIT 5;\n", null);

        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                String adres = c.getString(c.getColumnIndex("deelgemeente"));
                Integer res = c.getInt(c.getColumnIndex("res"));
                resultlist.add(new Result(adres, res));
            } while (c.moveToNext());
        }
        c.close();
        DB.closeDB();
        return resultlist;
    }

    public static List<Result> getLocations() {
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
