package BusinessLogic;

import Core.BrugerDTO;
import DataAccess.DAO_Bruger;
import DataAccess.IDAO_Bruger;


import java.sql.SQLException;

public class BLLBruger implements I_BLLBruger {
    private IDAO_Bruger daoBru = new DAO_Bruger();

    @Override
    public BrugerDTO opretEnkelBruger(BrugerDTO enkelBruger) throws SQLException {
        return daoBru.opretEnkelBruger(enkelBruger);
    }

    @Override
    public BrugerDTO visEnkelBruger(String CPR) throws SQLException {
        return null;
    }

    @Override
    public BrugerDTO redigerBruger(String gammelCPR, BrugerDTO nyeBruger) throws SQLException {
        return null;
    }

    @Override
    public BrugerDTO[] visAlleBrugere() throws SQLException {
        return new BrugerDTO[0];
    }
}