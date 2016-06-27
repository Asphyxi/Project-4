package groep2.project4;

/**
 * Created by Dennis on 24-6-2016.
 */
public class Trommel {

    public String Adres;
    public Double longit;
    public Double latit;

    public Trommel(String straat, String thv, String x, String y){
        if(null!=x || null!=y){
            this.Adres = straat+" "+thv;
            this.longit = Double.parseDouble(x);
            this.latit = Double.parseDouble(y);
        }else{
            this.Adres = "";
            this.longit = 0.0;
            this.latit = 0.0;
        }


    }

}
