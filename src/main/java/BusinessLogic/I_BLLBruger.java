package BusinessLogic;

import Core.BrugerDTO;
import Core.RaavareDTO;

import java.sql.SQLException;

public interface I_BLLBruger {
    BrugerDTO opretEnkelBruger(BrugerDTO enkelBruger) throws SQLException;

    BrugerDTO visEnkelBruger(String CPR) throws SQLException;

    BrugerDTO redigerBruger(String gammelCPR, BrugerDTO nyeBruger) throws SQLException;

    BrugerDTO[] visAlleBrugere() throws  SQLException;

}
