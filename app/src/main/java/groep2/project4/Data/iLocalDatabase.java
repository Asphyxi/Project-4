package groep2.project4.Data;

public interface iLocalDatabase {

    void PrepareDB();
    void Insert(String table, String columns, String values);
    void openDB();
    void closeDB();
}
