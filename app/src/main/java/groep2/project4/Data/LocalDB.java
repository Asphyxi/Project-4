package groep2.project4.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Locale;

public class LocalDB {

    public LocalDB(Context cont) {
        this.cont = cont;
    }

    SQLiteDatabase thisDB = null;
    String trommeltable = "fietstrommels";
    String dieftable = "fietsdiefstallen";
    String createttable = "CREATE TABLE " + trommeltable + " ('adres' TEXT, 'longit' REAL, 'latit' REAL, 'deelgemeente' TEXT);";
    String createdtable = "CREATE TABLE " + dieftable + " ('deelgemeente' TEXT, 'datum' TEXT, 'kleur' TEXT, 'merk' TEXT);";
    Context cont;

    public void CreateDB() {
        try{
            thisDB = cont.openOrCreateDatabase("infodb", Context.MODE_PRIVATE, null);
            thisDB.execSQL("DROP table IF EXISTS "+ dieftable +";");
            thisDB.execSQL("DROP table IF EXISTS "+ trommeltable+ ";");
            thisDB.execSQL(createdtable);
            thisDB.execSQL(createttable);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("DBError",e.toString());
        } finally {
            thisDB.close();
        }
    }

    public void InsertIntoDiefstal(String deelgemeente, String datum, String kleur, String merk) {
        String sql = "INSERT INTO %s (adres, longit, latit, deelgemeente) VALUES ('%s',%f,%f,'%s')";
        thisDB.execSQL(String.format(Locale.getDefault(), sql, dieftable, deelgemeente, datum, kleur, merk));
    }

    public void InsertIntoTrommel(String adres, Double longit, Double latit, String deelgemeente) {
        String sql = "INSERT INTO %s (adres, longit, latit, deelgemeente) VALUES ('%s',%f,%f,'%s')";
        thisDB.execSQL(String.format(Locale.getDefault(), sql, trommeltable, adres, longit, latit, deelgemeente));
    }

    public void openDB() {
        thisDB = SQLiteDatabase.openDatabase(cont.getDatabasePath("infodb").getAbsolutePath(), null, Context.MODE_PRIVATE);
    }

    public void closeDB() {
        if (thisDB.isOpen()) {
            thisDB.close();
        }
    }



}
