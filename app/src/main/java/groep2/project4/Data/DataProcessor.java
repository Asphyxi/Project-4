package groep2.project4.Data;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    CSVReader csvReader = null;
    Context myContext;
    String Filename;

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

    public List<DataType> ProcessInfo(List<String[]> raw) {
        List<DataType> result = new ArrayList<>();

        for (String[] info:raw) {
            if (Filename.equals("trommels.csv")){
                if (!info[18].equals("") && !info[19].equals(""))
                    result.add(new Trommel(info[9], info[10], info[28], info[18], info[19]));
            } else if (Filename.equals("diefstal.csv")){
                result.add(new Diefstal(info[8], info[1], info[24], info[22]));
            }
        }
        return result;
    }

    public List<DataType> RetrieveInfo() {
        return ProcessInfo(GetInfo());
    }
}
