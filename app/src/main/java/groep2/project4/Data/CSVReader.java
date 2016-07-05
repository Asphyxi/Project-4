package groep2.project4.Data;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements iDataReader {

    public static List<String[]> ReadFile(Context myContext, String filename) {
        String line;
        String cvsSplitBy = ",";
        List<String[]> datalist = new ArrayList<>();
        InputStreamReader is = null;
        BufferedReader br;

        try {
            is = new InputStreamReader(myContext.getAssets().open(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert is != null;
        br = new BufferedReader(is);

        try {
            br.readLine();
            while ((line = br.readLine()) != null) {
                try {
                    datalist.add(line.split(cvsSplitBy));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return datalist;
    }
}
