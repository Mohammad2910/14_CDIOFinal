package DataAccess;

import Core.DTO_RaavareBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_RaavareBatch implements IDAO_RaavareBatch {

    @Override
    public void opretRaavareBatch(DTO_RaavareBatch raavareBatchDTO) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO Raavarebatch VALUES (?,?,?,?)");
            preSt.setInt(1, raavareBatchDTO.getRaavareBatchID());
            preSt.setDouble(2,raavareBatchDTO.getRaavareMaengde());
            preSt.setString(3,raavareBatchDTO.getLeverandoer());
            preSt.setInt(4,raavareBatchDTO.getRaavareID());
            System.out.println(preSt);
            preSt.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<DTO_RaavareBatch> visAlleRaavareBatches() throws SQLException {
        List<DTO_RaavareBatch> raavareBatchArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM Raavarebatch");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                raavareBatchArray.add(new DTO_RaavareBatch(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getString(3), resultSet.getInt(4)));
            }

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return raavareBatchArray;
    }
}
