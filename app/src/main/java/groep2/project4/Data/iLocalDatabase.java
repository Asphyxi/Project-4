package groep2.project4.Data;

public interface iLocalDatabase {

    void PrepareDB();
    void InsertIntoDiefstal(String key, String deelgemeente, Integer datum, String kleur, String merk);
    void InsertIntoTrommel(String key, String adres, Double longit, Double latit, String deelgemeente);
    void openDB();
    void closeDB();
}
