package DataAccess;
import Core.ReceptDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Recept implements IDAO_Recept {
    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, ReceptDTO recept) throws SQLException{
        try{
            preSt.setInt(1, recept.getReceptID());
            preSt.setString(2,recept.getReceptNavn());

        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }

    private PreparedStatement setCreatePreparedStatement2(PreparedStatement preSt, double a, double b, int c, int d) throws SQLException{
        try{
            preSt.setDouble(1, a);
            preSt.setDouble(2,b);
            preSt.setInt(3,c);
            preSt.setInt(4,d);

        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }

    @Override
    public void opretEnkelRecept(ReceptDTO enkelRecept, int a, double b, double c) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            try {
                PreparedStatement preSt = conn.prepareStatement("INSERT INTO Recept VALUES(?,?)");

                setCreatePreparedStatement(preSt,enkelRecept);

                preSt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            PreparedStatement preSt2 = conn.prepareStatement("INSERT INTO Receptraavare VALUES(?,?,?,?)");

            setCreatePreparedStatement2(preSt2,b,c,enkelRecept.getReceptID(),a);

            preSt2.executeUpdate();

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ReceptDTO> visAlleRecepter() throws SQLException {
        List<ReceptDTO> receptArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM Recept");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                receptArray.add(new ReceptDTO(resultSet.getInt(1), resultSet.getString(2)));
            }

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return receptArray;
    }
}
