package groep2.project4.Data;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import groep2.project4.DrawerActivity;

public class InformationRetriever {

    static LocalDB DB = (LocalDB) DrawerActivity.getDb();

    public static List<List<Result>> getPieChart() {
        List<List<Result>> result = new ArrayList<>();
        List<Result> kleuren = new ArrayList<>();
        List<Result> merken = new ArrayList<>();

        DB.openDB(); //Opens the database and send it a query
        Cursor c = DB.thisDB.rawQuery("SELECT kleur, count(kleur) as res\n" +
                "FROM fietsdiefstallen\n" +
                "WHERE kleur <> '' \n" +
                "GROUP BY kleur\n",null);
        c.moveToFirst(); //Sets the cursor at the first result
        if (c.getCount() > 0) { //Go through the entire list, and retrieve usefull information
            do {
                String kleur = c.getString(c.getColumnIndex("kleur"));
                Integer res = c.getInt(c.getColumnIndex("res"));
                kleuren.add(new Result(kleur, res));
            } while (c.moveToNext());
        }
        result.add(kleuren); //Add the results
        c = DB.thisDB.rawQuery("SELECT merk, count(merk) as res\n" +
                "FROM fietsdiefstallen\n" +
                "WHERE merk <> '' \n" +
                "GROUP BY merk\n", null);
        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                String merk = c.getString(c.getColumnIndex("merk"));
                Integer res = c.getInt(c.getColumnIndex("res"));
                merken.add(new Result(merk, res));
            } while (c.moveToNext());
        }
        result.add(kleuren);
        result.add(merken);

        Log.i("Piechart", "Kleuren: " + kleuren.size() + " Merken " + merken.size());

        c.close(); //Close cursor, db and return all results
        DB.closeDB();
        return result;
    }

    public static List<Result> getTrommels() {
        List<Result> result = new ArrayList<>();

        DB.openDB();
        Cursor c = DB.thisDB.rawQuery("SELECT deelgemeente, count(deelgemeente) as res\n" +
                "FROM fietstrommels\n" +
                "WHERE deelgemeente <> ''\n" +
                "GROUP BY deelgemeente;",null);
        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                String deelgemeente = c.getString(c.getColumnIndex("deelgemeente"));
                Integer res = c.getInt(c.getColumnIndex("res"));
                result.add(new Result(deelgemeente, res));
            } while (c.moveToNext());
        }
        c.close();
        DB.closeDB();
        return result;
    }

    public static List<Result> getDiefStallen() {
        List<Result> result = new ArrayList<>();

        DB.openDB();
        Cursor c = DB.thisDB.rawQuery("select *\n" +
                "from(\n" +
                "select 'Centrum' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('12 COOL', '19 DIJKZIGT', '11 OUDE WESTEN', '10 STADSDRIEHOEK', '13 CS-KWARTIER')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Charlois' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('72 CARNISSE', '93 HEIJPLAAT', '74 OUD-CHARLOIS', '77 PENDRECHT', '71 TARWEWIJK', '75 WIELEWAAL', '73 ZUIDWIJK', '76 ZUIDPLEIN')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Delfshaven' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('21 BOSPOLDER', '22 TUSSENDIJKEN', '20 DELFSHAVEN', '29 SCHIEMOND', '25 MIDDELLAND', '24 NIEUWE WESTEN', '23 SPANGEN', '28 WITTE DORP', '27 OUD MATHENESSE')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Feijenoord' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('86 AFRIKAANDERWIJK', '81 BLOEMHOF', '87 FEIJENOORD', '82 HILLESLUIS', '85 KATENDRECHT', '88 NOORDEREILAND', '80 VREEWIJK', '17 FEIJENOORD-KOP VAN ZUID')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Hillegersberg' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('61 HILLEGERSBERG-ZUID', '62 HILLEGERSBERG-NOORD', '65 MOLENLAANKWARTIER', '60 SCHIEBROEK', '64 TERBREGGE')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Hoek van Hollland' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('__ HOEK VAN HOLLAND', '__ OUDE HOEK')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Hoogvliet' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('43 OUDELAND')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'IJsselmonde' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('90 BEVERWAARD', '84 LOMBARDIJEN', '89 GROOT IJSSELMONDE')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Kralingen/Crooswijk' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('36 NIEUW CROOSWIJK', '37 OUD CROOSWIJK', '45 DE ESCH', '41 KRALINGEN-WEST', '42 KRALINGEN-OOST', '14 RUBROEK', '47 STRUISENBURG')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Noord' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('15 AGNIESEdeelgemeente', '31 BERGPOLDER', '32 BLIJDORP', '34 LISKWARTIER', '35 OUDE NOORDEN', '16 PROVENIERSWIJK')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Overschie' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('51 KLEINPOLDER', '57 LANDZICHT', '56 OVERSCHIE', '55 ZESTIENHOVEN')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Pernis' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('91 PERNIS')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Prins Alexander' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('49 HET LAGE LAND', '46 KRALINGSEVEER', '68 NESSELANDE', '63 OMMOORD', '67 OOSTERFLANK', '48 PRINSENLAND', '66 ZEVENKAMP')\n" +
                "group by maand\n" +
                "union\n" +
                "select 'Rozenburg' as deelgemeente, maand, count(maand) as res\n" +
                "from fietsdiefstallen\n" +
                "where deelgemeente in ('04 ROZENBURG')\n" +
                "group by maand) as superopa\n" +
                "order by deelgemeente, maand\n",null);
        c.moveToFirst();
        if (c.getCount() > 0) {
            do {
                String deelgemeente = c.getString(c.getColumnIndex("deelgemeente"));
                Integer maand = c.getInt(c.getColumnIndex("maand"));
                Integer res = c.getInt(c.getColumnIndex("res"));
                result.add(new Result(deelgemeente, maand, res));
            } while (c.moveToNext());
        }
        c.close();
        DB.closeDB();
        return result;
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
