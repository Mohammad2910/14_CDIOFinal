package DataAccess;

import Core.DTO_Afvejning;
import Core.DTO_Bruger;
import Core.DTO_Tomafvejning;
import com.mysql.cj.exceptions.MysqlErrorNumbers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Afvejning implements IDAO_Afvejning {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, DTO_Afvejning afvejning) throws SQLException {
        try {
            preSt.setDouble(1,afvejning.getTara());
            preSt.setDouble(2,afvejning.getNetto());
            preSt.setInt(3,afvejning.getRaavareBatchID());
            preSt.setString(4,afvejning.getCpr());
            preSt.setInt(5,afvejning.getProduktBatchID());
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return preSt;
    }


    @Override
    public void opretEnkeltAfvejning(DTO_Afvejning afvejning) throws SQLException {
        boolean failed = false;
        int retries = 10;

        do {
            failed = false;

            try {
                DataAccess dataAccess = new DataAccess();
                Connection conn = dataAccess.connection;
                PreparedStatement preSt = conn.prepareStatement("INSERT INTO produktbatchafvejning VALUES(?,?,?,?,?,now())");
                setCreatePreparedStatement(preSt, afvejning);
                preSt.executeUpdate();


                conn.close();
            } catch (SQLException e) {
                failed = true;
                if (e.getErrorCode() == MysqlErrorNumbers.ER_LOCK_DEADLOCK){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
                throw new SQLException();
            }
        }
        while (failed && retries-- > 0);
        if (failed && retries == 0){
            throw new SQLException();
        }
    }

    @Override
    public List<DTO_Afvejning> visEnkeltAfvejning(int produktBatchID) throws SQLException {
        List<DTO_Afvejning> afvejningArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT * FROM produktbatchafvejning WHERE produktbatchid = ?");
            preSt.setInt(1,produktBatchID);

            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                afvejningArray.add(new DTO_Afvejning(resultSet.getDouble(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6)));
            }

            if (afvejningArray.isEmpty()){
                afvejningArray.add(new DTO_Afvejning(0,0,0,"",0,""));
            }


            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return afvejningArray;
    }

    @Override
    public List<DTO_Tomafvejning> visTomAfvejning(int produktBatchID) throws SQLException {
        List<DTO_Tomafvejning> tomArray = new ArrayList<>();

        try{
            DataAccess dataAccess = new DataAccess();
            Connection conn = dataAccess.connection;
            PreparedStatement preSt = conn.prepareStatement("SELECT produktbatch.produktbatchid, raavare.raavarenavn, receptraavare.nonnetto, receptraavare.tolerance FROM recept left outer join receptraavare on recept.receptid = receptraavare.receptid left outer join produktbatch on produktbatch.receptid = recept.receptid left outer join raavare on receptraavare.raavareid = raavare.raavareid where produktbatch.produktbatchid = ?");
            preSt.setInt(1,produktBatchID);

            ResultSet resultSet = preSt.executeQuery();
            //Rykker pointeren til default række position foran Id, derefter til rækken med ID
            resultSet.beforeFirst();
            while (resultSet.next()) {
                tomArray.add(new DTO_Tomafvejning(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getDouble(4)));
            }

            conn.close();
        } catch(ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return tomArray;
    }
}
