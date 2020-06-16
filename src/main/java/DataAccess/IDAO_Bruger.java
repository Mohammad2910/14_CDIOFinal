package DataAccess;

import Core.BrugerDTO;
import java.sql.SQLException;


public interface IDAO_Bruger {
    BrugerDTO opretEnkelBruger(BrugerDTO enkelBruger) throws SQLException;
    BrugerDTO laesEnkelBrugerId(String cprNr) throws SQLException;
}
