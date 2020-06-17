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
    @Override
    public void opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO Recept VALUES(?,?)");

            setCreatePreparedStatement(preSt,enkelRecept);

            preSt.executeUpdate();

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
