package DataAccess;

import Core.DTO_Raavare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Raavare implements IDAO_Raavare {

    @Override
    public DTO_Raavare opretEnkelRaavare(DTO_Raavare enkelRaavare) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO raavare VALUES(?,?)");
            preSt.setInt(1, enkelRaavare.getRaavareID());
            preSt.setString(2,enkelRaavare.getRaavareNavn());
            if(enkelRaavare.getRaavareID() == 0) {
                throw new SQLException();
            } else {
                preSt.executeUpdate();
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return laesEnkelRaavareId(enkelRaavare.getRaavareID());
    }


    @Override
    public DTO_Raavare laesEnkelRaavareId(int raavareId) throws SQLException{
        DTO_Raavare raa;

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM raavare WHERE raavareid = ?");

            preSt.setInt(1,raavareId);
            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            resultSet.next();

            raa = new DTO_Raavare(resultSet.getInt(1), resultSet.getString(2));

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return raa;
    }

    @Override
    public List<DTO_Raavare> visAlleRaavare() throws SQLException {
        List<DTO_Raavare> raavareArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM raavare");

            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                raavareArray.add(new DTO_Raavare(resultSet.getInt(1), resultSet.getString(2)));
            }

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return raavareArray;
    }

    @Override
    public void redigerRaavare(DTO_Raavare nyRaavare) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("UPDATE raavare SET RaavareNavn = ? WHERE RaavareID = ?;");
           preSt.setInt(2,nyRaavare.getRaavareID());
           preSt.setString(1,nyRaavare.getRaavareNavn());
            System.out.println(preSt);

            PreparedStatement preSt2 = conn.prepareStatement("SELECT * from raavare WHERE RaavareID = ?;");

            preSt2.setInt(1, nyRaavare.getRaavareID());
            ResultSet resultSet = preSt2.executeQuery();
            resultSet.beforeFirst();
            if (!resultSet.next()) {
                throw new SQLException();
            } else {
                preSt.executeUpdate();
            }
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
