package groep2.project4.Data;

public class Result {

    public String identifier;
    public Integer res;

    public Result(String identifier, Integer res) {
        this.identifier = identifier;
        this.res = res;
    }

    public String adres;
    public Double longit; //?
    public Double latit; // ?

    public Result(String adres, Double latit, Double longit){
        this.adres = adres;
        this.latit = latit;
        this.longit = longit;
    }

    public Integer maand;
    public Result(Integer maand, Integer res) {
        this.maand = maand;
        this.res = res;
    }
    
    public String deelgemeente;
    
    public Result(String deelgemeente, Integer maand, Integer res) {
        this.deelgemeente = deelgemeente;
        this.maand = maand;
        this.res = res;
    }

}
