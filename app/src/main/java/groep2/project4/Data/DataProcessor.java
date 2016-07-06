package groep2.project4.Data;

import android.content.Context;

import java.util.List;

import groep2.project4.DrawerActivity;

public class DataProcessor {

    CSVReader csvReader = null;
    Context myContext;
    String Filename;
    iLocalDatabase DB = DrawerActivity.getDb();

    public DataProcessor(Context myContext, String Filename) {
        csvReader = new CSVReader();
        this.myContext = myContext;
        this.Filename = Filename;
    }

    public List<String[]> GetInfo() {
        List<String[]> result;
        result = CSVReader.ReadFile(myContext, Filename);
        return result;
    }

    public void ProcessInfo(List<String[]> raw) {
        DB.openDB();
        for (String[] info:raw) {
            if (Filename.equals("trommels.csv")){
                if (!info[0].equals("") && !info[18].equals("") && !info[19].equals(""))
                    try {
                        DB.InsertIntoTrommel(info[0], info[9]+" "+info[10], Double.parseDouble(info[18]), Double.parseDouble(info[19]), info[28]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            } else if (Filename.equals("diefstal.csv")){
                if (!info[0].equals("") && !info[8].equals("") && !info[17].equals("") && !info[24].equals("") && !info[22].equals(""))
                    try {
                        DB.InsertIntoDiefstal(info[0], info[8], Integer.parseInt(info[17]), info[24], info[22]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
            }
        }
        DB.closeDB();
    }

    public void RetrieveInfo() {
        ProcessInfo(GetInfo());
    }
}
