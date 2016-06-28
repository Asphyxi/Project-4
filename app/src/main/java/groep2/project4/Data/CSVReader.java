package groep2.project4.Data;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements DataReader {

    public static List<String[]> ReadFile(Context myContext, String filename) {
        String line;
        String cvsSplitBy = ",";
        List<String[]> datalist = new ArrayList<>();

        try {
            InputStreamReader is = new InputStreamReader(myContext.getAssets().open(filename));
            BufferedReader br = new BufferedReader(is);
            br.readLine();
            while ((line = br.readLine()) != null) {
                try {
                    datalist.add(line.split(cvsSplitBy));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Skip", "Invalid data was skipped");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datalist;
    }
}
