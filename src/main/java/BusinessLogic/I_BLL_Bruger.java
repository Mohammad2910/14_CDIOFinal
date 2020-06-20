package BusinessLogic;

import Core.DTO_Bruger;

import java.sql.SQLException;
import java.util.List;

public interface I_BLL_Bruger {
    DTO_Bruger opretEnkelBruger(DTO_Bruger enkelBruger) throws SQLException;

    DTO_Bruger visEnkelBruger(String CPR) throws SQLException;

    void redigerBruger(DTO_Bruger nyeBruger) throws SQLException;

    void sletBruger(String CPR) throws SQLException;

    List<DTO_Bruger> visAlleBrugere() throws  SQLException;

}
