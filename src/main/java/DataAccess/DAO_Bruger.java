package DataAccess;

import Core.BrugerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Bruger implements IDAO_Bruger {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, BrugerDTO opr) throws SQLException {
        try {
            preSt.setString(1, opr.getCprNr());
            preSt.setString(2, opr.getBrugerNavn());
            preSt.setString(3, opr.getIni());
            preSt.setString(4, opr.getRolle());
            preSt.setString(5, opr.getBrugerStatus());
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return preSt;
    }
    @Override
    public BrugerDTO opretEnkelBruger(BrugerDTO enkelBruger) throws SQLException {
        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO brugere VALUES(?,?,?,?,?)");

            setCreatePreparedStatement(preSt,enkelBruger);

            preSt.executeUpdate();


            conn.close();

        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return laesEnkelBrugerId(enkelBruger.getCprNr());
    }

    @Override
    public BrugerDTO laesEnkelBrugerId(String cprNr) throws SQLException {
        BrugerDTO bru;

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM brugere WHERE CPR = ?");

            preSt.setString(1, cprNr);
            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran CPR, derefter til rækken med CPR
            resultSet.beforeFirst();
            resultSet.next();

            bru = new BrugerDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));

            conn.close();
        }catch(SQLException | ClassNotFoundException e){
            throw new SQLException(e);
        }
        return bru;
    }

    @Override
    public List<BrugerDTO> visAlleBrugere() throws SQLException {
        List<BrugerDTO> brugerArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM brugere");

            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                brugerArray.add(new BrugerDTO(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
            }

            conn.close();
        } catch(SQLException | ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return brugerArray;
    }

    @Override
    public void redigerBruger(BrugerDTO nyBruger) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("UPDATE brugere SET BrugerNavn = ?, Initialer = ?, Rolle = ? WHERE Cpr = ?;");

            preSt.setString(1, nyBruger.getBrugerNavn());
            preSt.setString(2, nyBruger.getIni());
            preSt.setString(3, nyBruger.getRolle());
            preSt.setString(4, nyBruger.getCprNr());
            System.out.println(preSt);


            preSt.executeUpdate();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fjernBruger(String cprNr) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("UPDATE Brugere SET BrugerStatus = \'Ikke Aktiv\' WHERE Cpr = ?;");

            preSt.setString(1,cprNr);

            preSt.executeUpdate();

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
