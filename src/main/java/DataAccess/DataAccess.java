package DataAccess;

import java.sql.*;

public class DataAccess implements IDataAccess {
    public final String url = "jdbc:mysql://" + "localhost:3306" + "/webshop" + "?characterEncoding=utf8&serverTimezone=UTC";
    public final String username = "root";
    public final String password = "1234";
    public Connection connection;



    public DataAccess() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }




    @Override
    public void InsertRaavare(int id, String navn) throws SQLException {

    }

    @Override
    public void InsertBruger(String cpr, String navn, String initialer, String rolle, String brugerStatus) throws SQLException {

    }

    @Override
    public void InsertRecept(int id, String navn) throws SQLException {

    }

    @Override
    public void InsertReceptRaavare(double nonNetto, double tolerance, int receptID, int raavareID) {

    }

    @Override
    public void InsertProduktBatch(int produktBatchID, String produktBatchStatus, int receptID) throws SQLException {

    }

    @Override
    public void InsertRaavareBatch(int raavareBatchID, double maengde, String leverandoer, int raavareID) throws SQLException {

    }

    @Override
    public void InsertProduktBatchAfvejning(double tara, double netto, int raavareBatchID, String cpr, int produktBatchID) throws SQLException {

    }

    @Override
    public String[][] getAlleBrugerinfo() throws SQLException {
    }

    @Override
    public String[][] getAlleRaavareinfo() throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getRecept(int id, String navn) throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getAlleRecepter() throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getAlleRaavareBatch() throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getRaavareBatch() throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getProduktBatch(int produktbatchID) throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getAlleProduktBatch() throws SQLException {
        return new String[0][];
    }

    @Override
    public String[][] getProduktBatchAfvejning(int produktbatchID) throws SQLException {
        return new String[0][];
    }

    @Override
    public void fjernBruger(String cpr) throws SQLException {

    }

    @Override
    public void redigerBruger(String cpr, String navn, String initialer, String rolle, String brugerStatus) throws SQLException {

    }

    @Override
    public void redigerRaavare(int id, String navn) throws SQLException {

    }


    public String[][] outputDBString(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        int[] columnWidths = new int[columnCount + 1]; //columnWidths[0] to be ignored
        int valueLength;
        int rowCount = 0;

        //Find maximun width for each column and store in columnWidths[]
        for (int i = 1; i <= columnCount; i++) {
            columnWidths[i] = resultSetMetaData.getColumnName(i).length();
        }

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                if (resultSet.getString(i) == null) {
                    columnWidths[i] = 15;
                } else {
                    valueLength = resultSet.getString(i).length();
                    if (valueLength > columnWidths[i]) {
                        columnWidths[i] = valueLength;
                    }
                }
            }
            rowCount++;
        }

        //Print all table rows
        resultSet.beforeFirst(); //Set pointer for resultSet.next()
        String[][] returnArray = new String[rowCount][columnWidths.length];
        rowCount = 0;
        while (resultSet.next()) {
            //Print all values in a row
            for (int i = 1; i <= columnCount; i++) {
                if (resultSet.getString(i) == null) {
                } else {
                    returnArray[rowCount][i-1] = rightPad(resultSet.getString(i), resultSet.getString(i).length()-1);
                }
            }
            rowCount++;
        }
        return returnArray;
    }


    public static String rightPad(String stringToPad, int width){
        while(stringToPad.length() <= width){
            stringToPad = stringToPad + " ";
        }
        return stringToPad;
    }


}
