package DataAccess;

import Core.BrugerDTO;
import Core.RaavareDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAO_Bruger implements I_DAO_Bruger {

    private PreparedStatement setCreatePreparedStatement(PreparedStatement preSt, BrugerDTO opr) throws SQLException {
        try{
            preSt.setString(1, opr.getCprNr());
            preSt.setString(2, opr.getBrugerNavn());
            preSt.setString(3, opr.getIni());
            preSt.setString(4, opr.getRoller());
            preSt.setBoolean(5, opr.isBrugerStatus());
        }
        catch (SQLException e){
            throw new SQLException(e);
        }
        return preSt;
    }
    @Override
    public BrugerDTO getBruger(String cprNr) throws DALException {
        return null;
    }

    @Override
    public List<BrugerDTO> getBrugerList() throws DALException {
        return null;
    }

    @Override
    public void opretBruger(BrugerDTO bruger) throws DALException {

    }

    @Override
    public void opdaterBruger(BrugerDTO bruger) throws DALException {

    }
}
