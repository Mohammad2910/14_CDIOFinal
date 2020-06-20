package DataAccess;

import Core.DTO_ReceptRaavare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_ReceptRaavare implements IDAO_ReceptRaavare {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, DTO_ReceptRaavare recRaa) throws SQLException{
        try{
            preSt.setInt(1, recRaa.getReceptID());
            preSt.setDouble(2,recRaa.getNonNetto());
            preSt.setDouble(3,recRaa.getTolerance());
            preSt.setInt(4, recRaa.getRaavareID());
        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }

    @Override
    public List<DTO_ReceptRaavare> visReceptRaavare(int receptID) throws SQLException {
        List<DTO_ReceptRaavare> recRaaArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("select ReceptID, nonNetto, Tolerance, RaavareID from recept natural join receptraavare where receptID = ?");

            preSt.setInt(1, receptID);
            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                recRaaArray.add(new DTO_ReceptRaavare(resultSet.getInt(1), resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getInt(4)));
            }
            conn.close();

        }catch(ClassNotFoundException e){
            throw new SQLException(e);
        }
        return recRaaArray;
    }
}
