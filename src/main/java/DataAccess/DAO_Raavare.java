package DataAccess;

import Core.RaavareDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Raavare implements IDAO_Raavare {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, RaavareDTO raa) throws SQLException{
        try{
            preSt.setInt(1, raa.getRaavareID());
            preSt.setString(2,raa.getRaavareNavn());
        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }
    @Override
    public RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO råvare VALUES(?,?)");

            setCreatePreparedStatement(preSt,enkelRaavare);

            preSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return laesEnkelRaavareId(enkelRaavare.getRaavareID());
    }


    @Override
    public RaavareDTO laesEnkelRaavareId(int raavareId) throws SQLException{
        RaavareDTO raa;

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM råvare WHERE råvareid = ?");

            preSt.setInt(1,raavareId);
            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            resultSet.next();

            raa = new RaavareDTO(resultSet.getInt(1), resultSet.getString(2));

        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return raa;
    }
}
