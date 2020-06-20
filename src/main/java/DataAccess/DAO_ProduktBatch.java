package DataAccess;

import Core.DTO_ProduktBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_ProduktBatch implements IDAO_ProduktBatch {


    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, DTO_ProduktBatch prBa) throws SQLException{
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
    public void opretProduktBatch(DTO_ProduktBatch produktBatchDTO) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO ProduktBatch VALUES (?,?,?)");

            setCreatePreparedStatement(preSt,produktBatchDTO);

            preSt.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DTO_ProduktBatch> visAlleProduktBatches() throws SQLException {

        List<DTO_ProduktBatch> produktBatchArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM Produktbatch");

            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                produktBatchArray.add(new DTO_ProduktBatch(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2), "0",0,0,0));
            }


            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return produktBatchArray;
    }


    @Override
    public List<DTO_ProduktBatch> visEnkelProduktBatch(int produktBatchID) throws SQLException {
        List<DTO_ProduktBatch> produktBatchArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT produktbatch.produktbatchid, recept.receptid, produktbatch.produktbatchstatus, brugere.cpr, raavarebatch.raavarebatchid, produktbatchafvejning.tara, produktbatchafvejning.netto FROM Produktbatch LEFT OUTER JOIN Recept on Produktbatch.receptid = recept.receptid LEFT OUTER JOIN produktbatchafvejning on produktbatch.produktbatchid = produktbatchafvejning.produktbatchid LEFT OUTER JOIN brugere on brugere.cpr = produktbatchafvejning.cpr LEFT OUTER JOIN raavarebatch ON raavarebatch.raavarebatchid = produktbatchafvejning.raavarebatchid WHERE produktbatch.produktbatchid = " + produktBatchID + ";" );
            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                produktBatchArray.add(new DTO_ProduktBatch(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getDouble(7)));
            }

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return produktBatchArray;
    }
}
