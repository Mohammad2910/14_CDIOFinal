package DataAccess;

import java.sql.*;

public class DataAccess {
    private final String url = "jdbc:mysql://" + "localhost:3306" + "/webshop" + "?characterEncoding=utf8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "1234";
    public Connection connection;
    private Statement statement;


    public DataAccess() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, username, password);
        this.statement = connection.createStatement();

    }


}
