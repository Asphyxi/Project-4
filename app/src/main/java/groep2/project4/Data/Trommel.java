package groep2.project4.Data;

import java.util.ArrayList;
import java.util.Arrays;

public class Trommel implements DataType {

    String adres;
    String longit;
    String latit;
    String deelgemeente;

    public Trommel(String straat, String thv, String deelgemeente, String x, String y){
        this.adres = straat+" "+thv;
        this.longit = x;
        this.latit = y;
        this.deelgemeente = deelgemeente;
    }

    public ArrayList<String> getInfo() {
        ArrayList<String> info = new ArrayList<>(4);
        info.addAll(Arrays.asList(adres, longit, latit, deelgemeente));
        return info;
    }
}
