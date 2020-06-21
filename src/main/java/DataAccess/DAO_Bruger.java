package DataAccess;

import Core.DTO_Bruger;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Bruger implements IDAO_Bruger {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, DTO_Bruger opr) throws SQLException {
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
    public DTO_Bruger opretEnkelBruger(DTO_Bruger enkelBruger) throws SQLException {
        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("INSERT INTO brugere VALUES(?,?,?,?,?)");

            setCreatePreparedStatement(preSt,enkelBruger);
            System.out.println(preSt);
//            if (Integer.parseInt(enkelBruger.getCprNr().substring(2,3)) == 1) {
//
//            }
            if (enkelBruger.getIni().indexOf('%') != -1) {
                throw new SQLException();
            } else {
                preSt.executeUpdate();
            }

            conn.close();

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return laesEnkelBrugerId(enkelBruger.getCprNr());
    }

    @Override
    public DTO_Bruger laesEnkelBrugerId(String cprNr) throws SQLException {
        DTO_Bruger bru;

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM brugere WHERE CPR = ?");

            preSt.setString(1, cprNr);
            ResultSet resultSet = preSt.executeQuery();

            //Rykker pointeren til default række position foran CPR, derefter til rækken med CPR
            resultSet.beforeFirst();
            resultSet.next();

            bru = new DTO_Bruger(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));

            conn.close();
        }catch(ClassNotFoundException e){
            throw new SQLException(e);
        }
        return bru;
    }

    @Override
    public List<DTO_Bruger> visAlleBrugere() throws SQLException {
        List<DTO_Bruger> brugerArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM brugere");

            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                brugerArray.add(new DTO_Bruger(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
            }

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return brugerArray;
    }

    @Override
    public void redigerBruger(DTO_Bruger nyBruger) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("UPDATE brugere SET BrugerNavn = ?, Initialer = ?, Rolle = ? WHERE Cpr = ?;");

            preSt.setString(1, nyBruger.getBrugerNavn());
            preSt.setString(2, nyBruger.getIni());
            preSt.setString(3, nyBruger.getRolle());
            preSt.setString(4, nyBruger.getCprNr());
            System.out.println(preSt);

            PreparedStatement preSt2 = conn.prepareStatement("SELECT * from brugere WHERE Cpr = ?;");

            preSt2.setString(1, nyBruger.getCprNr());
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

    @Override
    public void fjernBruger(String cprNr) throws SQLException {
        try {
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("UPDATE Brugere SET BrugerStatus = \'Ikke Aktiv\' WHERE Cpr = ?;");

            preSt.setString(1,cprNr);

            preSt.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
