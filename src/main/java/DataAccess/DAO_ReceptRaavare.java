package DataAccess;

import Core.ReceptDTO;
import Core.ReceptRaavareDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_ReceptRaavare implements IDAO_ReceptRaavare {
    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, String receptID) throws SQLException{
        try{
            preSt.setInt(1, Integer.parseInt(receptID));
        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }


    @Override
    public List<ReceptRaavareDTO> visAlleReceptRaavarer(String receptID) throws SQLException {
        List<ReceptRaavareDTO> receptRaavareArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM ReceptRåvare NATURAL JOIN Råvare WHERE ReceptID = ?");
            setCreatePreparedStatement(preSt,receptID);

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                receptRaavareArray.add(new ReceptRaavareDTO(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getInt(4),resultSet.getString(5)));
            }

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return receptRaavareArray;
    }
}
