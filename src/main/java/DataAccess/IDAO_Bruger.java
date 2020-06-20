package DataAccess;

import Core.DTO_Bruger;
import java.sql.SQLException;
import java.util.List;


public interface IDAO_Bruger {
    DTO_Bruger opretEnkelBruger(DTO_Bruger enkelBruger) throws SQLException;
    DTO_Bruger laesEnkelBrugerId(String cprNr) throws SQLException;
    List<DTO_Bruger> visAlleBrugere() throws SQLException;
    void redigerBruger(DTO_Bruger nyBruger) throws SQLException;
    void fjernBruger(String cprNr) throws SQLException;
}
