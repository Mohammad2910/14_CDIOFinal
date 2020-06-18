package DataAccess;

import Core.RaavareBatchDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_RaavareBatch implements IDAO_RaavareBatch {


    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, RaavareBatchDTO raBa) throws SQLException{
        try{
            preSt.setInt(1, raBa.getRaavareBatchID());
            preSt.setDouble(2,raBa.getRaavareMaengde());
            preSt.setString(3,raBa.getLeverandoer());
            preSt.setInt(4,raBa.getRaavareID());
        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }

    @Override
    public void opretRaavareBatch(RaavareBatchDTO raavareBatchDTO) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO Råvarebatch VALUES (?,?,?,?)");

            setCreatePreparedStatement(preSt,raavareBatchDTO);

            preSt.executeUpdate();

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<RaavareBatchDTO> visAlleRaavareBatches() throws SQLException {
        List<RaavareBatchDTO> raavareBatchArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM Råvarebatch");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                raavareBatchArray.add(new RaavareBatchDTO(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getString(3), resultSet.getInt(4)));
            }

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return raavareBatchArray;
    }
}
