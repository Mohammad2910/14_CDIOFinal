package BusinessLogic;

import Core.DTO_Bruger;
import DataAccess.DAO_Bruger;
import DataAccess.IDAO_Bruger;


import java.sql.SQLException;
import java.util.List;

public class BLL_Bruger implements I_BLL_Bruger {
    private IDAO_Bruger daoBru = new DAO_Bruger();

    @Override
    public DTO_Bruger opretEnkelBruger(DTO_Bruger enkelBruger) throws SQLException {
        return daoBru.opretEnkelBruger(enkelBruger);
    }

    @Override
    public DTO_Bruger visEnkelBruger(String CPR) throws SQLException {
        return daoBru.laesEnkelBrugerId(CPR);
    }


    @Override
    public void redigerBruger(DTO_Bruger nyeBruger) throws SQLException {
        daoBru.redigerBruger(nyeBruger);
    }

    @Override
    public void sletBruger(String CPR) throws SQLException {
        daoBru.fjernBruger(CPR);
    }

    @Override
    public List<DTO_Bruger> visAlleBrugere() throws SQLException {
        return daoBru.visAlleBrugere();
    }
}
