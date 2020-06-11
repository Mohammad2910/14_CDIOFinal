package DataAccess;


import java.sql.SQLException;

public interface IDataAccess {

    void InsertRaavare(int id, String navn) throws SQLException;
    void InsertBruger(String cpr, String navn, String initialer, String rolle) throws SQLException;
    void InsertRecept(int id, String navn) throws SQLException;
    void InsertReceptRaavare(double nonNetto, double tolerance, int receptID, int raavareID) throws SQLException;
    void InsertProduktBatch(int produktBatchID, String produktBatchStatus, int receptID) throws SQLException;
    void InsertRaavareBatch(int raavareBatchID, double maengde, String leverandoer, int raavareID) throws SQLException;
    void InsertProduktBatchAfvejning(double tara, double netto, int raavareBatchID, String cpr, int produktBatchID) throws SQLException;


    String[][] getAlleBrugerinfo() throws SQLException;
    String[][] getAlleRaavareinfo() throws SQLException;
    String[][] getRecept(int id) throws SQLException;
    String[][] getAlleRecepter() throws SQLException;
    String[][] getAlleRaavareBatch() throws SQLException;
    String[][] getRaavareBatch(int id) throws SQLException;
    String[][] getProduktBatch(int produktbatchID) throws SQLException;
    String[][] getAlleProduktBatch() throws SQLException;
    String[][] getProduktBatchAfvejning(int produktbatchID) throws SQLException;


    void fjernBruger(String brugerCPR) throws SQLException;
    void redigerBruger(String brugerCPR, String navn, String initialer, String rolle) throws SQLException;
    void redigerRaavare(int id, String navn) throws SQLException;












}
