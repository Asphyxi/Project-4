package groep2.project4.Data;

public class Result {

    public String identifier;
    public Integer amount;

    public Result(String identifier, Integer amount) {
        this.identifier = identifier;
        this.amount = amount;
    }

    public String adres;
    public Double longit;
    public Double latit;

    public Result(String adres, Double latit, Double longit){
        this.adres = adres;
        this.latit = latit;
        this.longit = longit;
    }

}
