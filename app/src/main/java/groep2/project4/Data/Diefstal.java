package groep2.project4.Data;

import java.util.ArrayList;
import java.util.Arrays;

public class Diefstal implements DataType {

    String deelgemeente;
    String datum;
    String kleur;
    String merk;

    public Diefstal(String deelgemeente, String datum, String kleur, String merk){
        this.deelgemeente = deelgemeente;
        this.datum = datum;
        this.kleur = kleur;
        this.merk = merk;
    }

    public ArrayList<String> getInfo() {
        ArrayList<String> info = new ArrayList<>(4);
        info.addAll(Arrays.asList(deelgemeente, datum, kleur, merk));
        return info;
    }
}
