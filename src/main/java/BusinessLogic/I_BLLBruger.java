package BusinessLogic;

import Core.BrugerDTO;
import Core.RaavareDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLBruger {
    BrugerDTO opretEnkelBruger(BrugerDTO enkelBruger) throws SQLException;

    BrugerDTO visEnkelBruger(String CPR) throws SQLException;

    void redigerBruger(BrugerDTO nyeBruger) throws SQLException;

    List<BrugerDTO> visAlleBrugere() throws  SQLException;

}
