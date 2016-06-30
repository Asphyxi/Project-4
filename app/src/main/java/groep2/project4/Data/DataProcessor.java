package groep2.project4.Data;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

import groep2.project4.DrawerActivity;
import groep2.project4.MainActivity;

public class DataProcessor {

    CSVReader csvReader = null;
    Context myContext;
    String Filename;
    LocalDB DB = DrawerActivity.getDb();

    public DataProcessor(Context myContext, String Filename) {
        csvReader = new CSVReader();
        this.myContext = myContext;
        this.Filename = Filename;
    }

    String SQL;
    DBConnect dbConnect = null;

    public DataProcessor(String SQL){
        this.SQL = SQL;
        this.dbConnect = new DBConnect();
    }

    public List<String[]> GetInfo() {
        List<String[]> result;
        if (csvReader!=null) {
            result = CSVReader.ReadFile(myContext, Filename);
        } else {
            result = null;
        }
        return result;
    }

    public void ProcessInfo(List<String[]> raw) {
        DB.openDB();
        for (String[] info:raw) {
            if (Filename.equals("trommels.csv")){
                if (!info[18].equals("") && !info[19].equals(""))
                    DB.InsertIntoTrommel(info[9]+" "+info[10], Double.parseDouble(info[18]), Double.parseDouble(info[19]), info[28]);
            } else if (Filename.equals("diefstal.csv")){
                DB.InsertIntoDiefstal(info[8], info[1], info[24], info[22]);
            }
        }
        DB.closeDB();
    }

    public void RetrieveInfo() {
        ProcessInfo(GetInfo());
    }
}
