package groep2.project4;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<String[]> FileReader(Context myContext, String filename) {
        String line;
        String cvsSplitBy = ",";
        String[] data;
        List<String[]> datalist = new ArrayList<>();
        AssetManager man = myContext.getAssets();

        try {
            InputStreamReader is = new InputStreamReader(myContext.getAssets().open(filename));
            BufferedReader br = new BufferedReader(is);


            while ((line = br.readLine()) != null) {
                data = line.split(cvsSplitBy);
                datalist.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Log.e("Amount", "The amount is" + datalist.size());
            return datalist;
        }
    }
}
