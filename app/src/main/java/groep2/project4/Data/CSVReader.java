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
            is = new InputStreamReader(myContext.getAssets().open(filename)); //Opens the given file in the assets folder
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert is != null;
        br = new BufferedReader(is);

        try {
            br.readLine(); //Skips header of CSV file
            while ((line = br.readLine()) != null) { //Go through each line and split them by every ,
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
                br.close(); //Closes the reader
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return datalist;
    }
}
