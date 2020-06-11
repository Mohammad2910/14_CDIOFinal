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
    public void InsertBruger(String cpr, String navn, String initialer, String rolle) throws SQLException {
        String query = "INSERT INTO Brugere VALUES('" + cpr + "' , '" + navn + "','" + initialer + "','" + rolle + "','Aktiv')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    @Override
    public void InsertRecept(int id, String navn) throws SQLException {
        String query = "INSERT INTO Brugere VALUES(" + id + ",'" + navn + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    @Override
    public void InsertReceptRaavare(double nonNetto, double tolerance, int receptID, int raavareID) throws SQLException {
        String query = "INSERT INTO Brugere VALUES(" + nonNetto + "," + tolerance + "," + receptID + "," + raavareID + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    @Override
    public void InsertProduktBatch(int produktBatchID, String produktBatchStatus, int receptID) throws SQLException {
        String query = "INSERT INTO Brugere VALUES(" + produktBatchID + ",'" + produktBatchStatus + "'," + receptID + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    @Override
    public void InsertRaavareBatch(int raavareBatchID, double maengde, String leverandoer, int raavareID) throws SQLException {
        String query = "INSERT INTO Brugere VALUES(" + raavareBatchID +"," + maengde + ",'" + leverandoer + "'," + raavareID + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    @Override
    public void InsertProduktBatchAfvejning(double tara, double netto, int raavareBatchID, String cpr, int produktBatchID) throws SQLException {
        String query = "INSERT INTO Brugere VALUES(" + tara + "," + netto + "," + raavareBatchID + ","+ ",'" + cpr + "'," + produktBatchID + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    @Override
    public String[][] getAlleBrugerinfo() throws SQLException {
        String query = "SELECT * FROM Brugere";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getAlleRaavareinfo() throws SQLException {
        String query = "SELECT * FROM Råvare";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getRecept(int id) throws SQLException {
        String query = "SELECT * FROM Recept WHERE ReceptID =" + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getAlleRecepter() throws SQLException {
        String query = "SELECT * FROM recept";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getAlleRaavareBatch() throws SQLException {
        String query = "SELECT * FROM råvarebatch";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getRaavareBatch(int id) throws SQLException {
        String query = "SELECT * FROM Recept WHERE råvarebatch =" + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getProduktBatch(int produktbatchID) throws SQLException {
        String query = "SELECT * FROM produktbatch WHERE produktbatchID =" + produktbatchID;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getAlleProduktBatch() throws SQLException {
        String query = "SELECT * FROM produktbatch";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    @Override
    public String[][] getProduktBatchAfvejning(int produktbatchID) throws SQLException {
        String query = "SELECT * FROM produktbatchafvejning WHERE produktbatchID =" + produktbatchID;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
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
