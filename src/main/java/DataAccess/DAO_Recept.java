package DataAccess;
import Core.DTO_Recept;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Recept implements IDAO_Recept {

    @Override
    public void opretEnkelRecept(DTO_Recept enkelRecept, int a, double b, double c) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            try {
                PreparedStatement preSt = conn.prepareStatement("INSERT INTO Recept VALUES(?,?)");
                preSt.setInt(1, enkelRecept.getReceptID());
                preSt.setString(2,enkelRecept.getReceptNavn());

                preSt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            PreparedStatement preSt2 = conn.prepareStatement("INSERT INTO Receptraavare VALUES(?,?,?,?)");
            preSt2.setDouble(1, b);
            preSt2.setDouble(2,c);
            preSt2.setInt(3,enkelRecept.getReceptID());
            preSt2.setInt(4,a);

            preSt2.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<DTO_Recept> visAlleRecepter() throws SQLException {
        List<DTO_Recept> receptArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM Recept");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                receptArray.add(new DTO_Recept(resultSet.getInt(1), resultSet.getString(2)));
            }

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return receptArray;
    }
}
