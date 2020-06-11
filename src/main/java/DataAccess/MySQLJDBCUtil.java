package DataAccess;

import java.sql.*;
import java.util.Scanner;

public class MySQLJDBCUtil {
    public static void main(String[] args) {
        //login
        Scanner input = new Scanner(System.in);
        System.out.println("Angiv user:");
        String username = input.nextLine();

        System.out.println("Angiv password:");
        String password = input.nextLine();
        //Edit username and password to match database login
        String url = "jdbc:mysql://" + "localhost:3306" + "/webshop" + "?characterEncoding=utf8&serverTimezone=UTC";
        try {
            //Change driver below to "com.mysql.jc.jdbc.Driver" if prompted by IntelliJ
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner scanner = new Scanner(System.in);
            String sqlQuery;
            //test
            System.out.println("Angiv sql query: ");
            //A query statement like "SELECT * FROM instructor;" or "SHOW TABLES;"
            sqlQuery = scanner.nextLine();


            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            int[] columnWidths = new int[columnCount + 1]; //columnWidths[0] to be ignored
            int valueLength;

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
            }
            //Print all attribute names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rightPad(resultSetMetaData.getColumnName(i), columnWidths[i]));
            }
            System.out.println();
            //Print all table rows
            resultSet.beforeFirst(); //Set pointer for resultSet.next()
            while (resultSet.next()) {
                //Print all values in a row
                for (int i = 1; i <= columnCount; i++) {
                    if (resultSet.getString(i) == null) {
                        System.out.print(rightPad("null", columnWidths[i]));
                    } else {
                        System.out.print(rightPad(resultSet.getString(i), columnWidths[i]));
                    }
                }
                System.out.println();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String rightPad(String stringToPad, int width){
        while(stringToPad.length() <= width){
            stringToPad = stringToPad + " ";
        }
        return stringToPad;
    }
}