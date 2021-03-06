package groep2.project4.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Locale;

public class LocalDB implements iLocalDatabase {

    public LocalDB(Context cont) {
        this.cont = cont;
    }

    SQLiteDatabase thisDB = null;
    String trommeltable = "fietstrommels";
    String dieftable = "fietsdiefstallen";
    String createttable = "CREATE TABLE IF NOT EXISTS " + trommeltable + " ('key' TEXT NOT NULL PRIMARY KEY, 'adres' TEXT, 'longit' REAL, 'latit' REAL, 'deelgemeente' TEXT);";
    String createdtable = "CREATE TABLE IF NOT EXISTS " + dieftable + " ('key' TEXT NOT NULL PRIMARY KEY, 'deelgemeente' TEXT, 'maand' INTEGER, 'kleur' TEXT, 'merk' TEXT);";
    Context cont;

    public void PrepareDB() {
        try{
            thisDB = cont.openOrCreateDatabase("infodb", Context.MODE_PRIVATE, null); //Open or create the database and create the necessary tables if they don't yet exist
            thisDB.execSQL(createdtable);
            thisDB.execSQL(createttable);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("DBError",e.toString());
        } finally {
            thisDB.close();
        }
    }

    public void InsertIntoDiefstal(String key, String deelgemeente, Integer datum, String kleur, String merk) { //Function to easily insert information into the diefstal table
        String sql = "INSERT OR IGNORE INTO %s (key, deelgemeente, maand, kleur, merk) VALUES ('%s','%s',%d,'%s','%s')";
        thisDB.execSQL(String.format(Locale.getDefault(), sql, dieftable, key, deelgemeente, datum, kleur, merk));
    }

    public void InsertIntoTrommel(String key, String adres, Double longit, Double latit, String deelgemeente) { //Function to easily insert information into the trommel table
        String sql = "INSERT OR IGNORE INTO %s (key, adres, longit, latit, deelgemeente) VALUES ('%s','%s',%f,%f,'%s')";
        thisDB.execSQL(String.format(Locale.getDefault(), sql, trommeltable, key, adres, longit, latit, deelgemeente));
    }

    public void openDB() {
        thisDB = SQLiteDatabase.openDatabase(cont.getDatabasePath("infodb").getAbsolutePath(), null, Context.MODE_PRIVATE); //Opens the database
    }

    public void closeDB() {
        if (thisDB.isOpen()) { //Closes the database if it's open
            thisDB.close();
        }
    }
}
