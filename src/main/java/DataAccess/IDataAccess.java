package DataAccess;


public interface IDataAccess {

    void InsertRaavare(int id, String navn);
    void InsertBruger(String cpr, String navn, String initialer, String rolle, String brugerStatus);
    void InsertRecept(int id, String navn);
    void InsertReceptRaavare(double nonNetto, double tolerance, int receptID, int raavareID);
    void InsertProduktBatch(int produktBatchID, String produktBatchStatus, int receptID);
    void InsertRaavareBatch(int raavareBatchID, double maengde, String leverandoer, int raavareID);
    void InsertProduktBatchAfvejning(double tara, double netto, int raavareBatchID, String cpr, int produktBatchID);


    String[][] getAlleBrugerinfo();
    String[][] getAlleRaavareinfo();
    String[][] getRecept(int id, String navn);
    String[][] getAlleRecepter();
    String[][] getAlleRaavareBatch();
    String[][] getRaavareBatch();
    String[][] getProduktBatch(int produktbatchID);
    String[][] getAlleProduktBatch();
    String[][] getProduktBatchAfvejning(int produktbatchID);


    void fjernBruger(String cpr);
    void redigerBruger(String cpr, String navn, String initialer, String rolle, String brugerStatus);
    void redigerRaavare(int id, String navn);












}
