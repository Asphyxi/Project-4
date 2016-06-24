package groep2.project4;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Trommel> FileReader(Context myContext, String filename) {
        String line;
        Trommel trommel;
        String cvsSplitBy = ",";
        String[] data;
        List<Trommel> datalist = new ArrayList<>();
        AssetManager man = myContext.getAssets();

        try {
            InputStreamReader is = new InputStreamReader(myContext.getAssets().open(filename));
            BufferedReader br = new BufferedReader(is);
            br.readLine();
            while ((line = br.readLine()) != null) {
                try {

                    data = line.split(cvsSplitBy);
                    trommel = new Trommel(data[9], data[10], data[18], data[19]);
                    Log.e("data", "0:" + data[0] + "  " + "1:" + data[1] + "  " + "2:" + data[2] + "  " + "3:" + data[3] + "  " + "4:" + data[4] + "  " + "5:" + data[5] + "  " + "6:" + data[6] + "  " + "7:" + data[7] + "  " + "8:" + data[8] + "  " + "9:" + data[9] + "  ");
                    datalist.add(trommel);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Skip", "skipped");
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("poep", "poep");
        } finally {
            Log.e("Amount", "The amount is" + datalist.size());
            return datalist;
        }
    }
}
