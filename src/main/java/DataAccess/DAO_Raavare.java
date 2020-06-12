package DataAccess;

import Core.RaavareDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Raavare implements I_DAL_Raavare {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, RaavareDTO res) throws SQLException{
        try{
            preSt.setInt(1, res.getRaavareID());
            preSt.setString(2,res.getRaavareNavn());
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
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO raavare (raavareid,raavarenavn)VALUES(?,?)");

            setCreatePreparedStatement(preSt,enkelRaavare);

            preSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laesEnkelRaavareId(enkelRaavare.getRaavareID());
    }


    @Override
    public RaavareDTO laesEnkelRaavareId(int raavareId) throws SQLException{
        RaavareDTO raa = null;

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM raavare WHERE raavareid = ?");

            preSt.setInt(1,raavareId);
            ResultSet resultSet = preSt.executeQuery();

            resultSet.beforeFirst();
            resultSet.next();

            raa = new RaavareDTO(resultSet.getInt(1), resultSet.getString(2));

        } catch(SQLException e) {
            throw new SQLException(e);
        }
        return raa;
    }
}
