package DataAccess;

import Core.BrugerDTO;
import Core.RaavareDTO;

import java.util.List;

public interface I_DAO_Bruger {
    BrugerDTO getBruger(String cprNr) throws DALException;
    List<BrugerDTO> getBrugerList() throws DALException;
    void opretBruger(BrugerDTO bruger) throws DALException;
    void opdaterBruger(BrugerDTO bruger) throws DALException;
}
