package DataAccess;

import Core.BrugerDTO;
import java.sql.SQLException;
import java.util.List;


public interface IDAO_Bruger {
    BrugerDTO opretEnkelBruger(BrugerDTO enkelBruger) throws SQLException;
    BrugerDTO laesEnkelBrugerId(String cprNr) throws SQLException;
    List<BrugerDTO> visAlleBrugere() throws SQLException;
    BrugerDTO redigerBruger(BrugerDTO nyBruger) throws SQLException;
    void fjernBruger(String cprNr) throws SQLException;


}
