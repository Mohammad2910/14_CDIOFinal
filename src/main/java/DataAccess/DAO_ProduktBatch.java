package DataAccess;

import Core.ProduktBatchDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_ProduktBatch implements IDAO_ProduktBatch {


    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, ProduktBatchDTO prBa) throws SQLException{
        try{
            preSt.setInt(1, prBa.getProduktBatchID());
            preSt.setString(2,prBa.getStatus());
            preSt.setInt(3, prBa.getReceptID());

        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;

    }


    @Override
    public void opretProduktBatch(ProduktBatchDTO produktBatchDTO) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO ProduktBatch VALUES (?,?,?)");

            setCreatePreparedStatement(preSt,produktBatchDTO);

            preSt.executeUpdate();

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProduktBatchDTO> visAlleProduktBatches() throws SQLException {

        List<ProduktBatchDTO> produktBatchArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM Produktbatch");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                produktBatchArray.add(new ProduktBatchDTO(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2), "0",0,0,0));
            }


            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return produktBatchArray;
    }


    @Override
    public List<ProduktBatchDTO> visEnkelProduktBatch(int produktBatchID) throws SQLException {

        List<ProduktBatchDTO> produktBatchArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT produktbatchid, receptid, produktbatchstatus, cpr, råvarebatchid, tara, netto FROM ProduktBatch NATURAL JOIN Råvare NATURAL JOIN ReceptRåvare NATURAL JOIN Recept NATURAL JOIN brugere NATURAL JOIN ProduktBatchAfvejning WHERE ProduktBatchID = " + produktBatchID +" GROUP BY råvareID;\n");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                produktBatchArray.add(new ProduktBatchDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getDouble(7)));
            }

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return produktBatchArray;
    }
}
