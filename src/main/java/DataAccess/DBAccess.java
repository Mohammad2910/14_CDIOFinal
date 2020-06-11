package DataAccess;

import java.sql.*;

public class DBAccess {
public final String url = "jdbc:mysql://" + "localhost:3306" + "/webshop" + "?characterEncoding=utf8&serverTimezone=UTC";
public final String username = "root";
public final String password = "1234";
public Connection connection;



    public DBAccess() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public String[][] getUserName(Connection connection, String cpr) throws SQLException {
        String query = "SELECT BrugerNavn FROM Brugere WHERE cpr = " + cpr;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    public String[][] getAllUsers(Connection connection) throws SQLException {
        String query = "SELECT * FROM Brugere";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
    }

    public String[][] getUserRole(Connection connection, String cpr) throws SQLException{
        String query = "SELECT Rolle FROM Brugere WHERE cpr = " + cpr;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return outputDBString(resultSet);
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
