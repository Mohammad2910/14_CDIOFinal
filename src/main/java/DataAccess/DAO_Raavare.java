package DataAccess;

import Core.RaavareDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO raavare VALUES(?,?)");

            setCreatePreparedStatement(preSt,enkelRaavare);

            preSt.executeUpdate();

            conn.close();
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
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM raavare WHERE raavareid = ?");

            preSt.setInt(1,raavareId);
            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            resultSet.next();

            raa = new RaavareDTO(resultSet.getInt(1), resultSet.getString(2));

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return raa;
    }

    @Override
    public List<RaavareDTO> visAlleRaavare() throws SQLException {
        List<RaavareDTO> raavareArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM raavare");

            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                raavareArray.add(new RaavareDTO(resultSet.getInt(1), resultSet.getString(2)));
            }

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return raavareArray;
    }

    @Override
    public void redigerRaavare(RaavareDTO nyRaavare) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("UPDATE raavare SET RaavareNavn = ? WHERE RaavareID = ?;");

           preSt.setInt(2,nyRaavare.getRaavareID());
           preSt.setString(1,nyRaavare.getRaavareNavn());

            preSt.executeUpdate();

            conn.close();



        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
