package groep2.project4.Data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    public List<Diefstal> diefstallen = new ArrayList<>();
    public List<Trommel> trommels = new ArrayList<>();
    private Context context;

    private DataProcessor diefstalproc = new DataProcessor(context, "diefstallen.csv");
    private DataProcessor trommelproc = new DataProcessor(context, "fietstrommels.csv");

    public void LoadData(Context context) {
        this.context = context;

        for (DataType data:diefstalproc.RetrieveInfo()) {
            if (Diefstal.class.isInstance(data)){
                diefstallen.add((Diefstal)data);
            }
        }
        for (DataType data:trommelproc.RetrieveInfo()) {
            if (Trommel.class.isInstance(data)){
                trommels.add((Trommel)data);
            }
        }
    }
}
