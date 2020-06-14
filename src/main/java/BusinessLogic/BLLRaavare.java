package BusinessLogic;

import Core.RaavareDTO;
import DataAccess.DAO_Raavare;
import DataAccess.I_DAL_Raavare;

import java.sql.SQLException;

public class BLLRaavare implements I_BLLRaavare {
    private I_DAL_Raavare daoRaa = new DAO_Raavare();

    @Override
    public RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException {
        return daoRaa.opretEnkelRaavare(enkelRaavare);
    }

    @Override
    public RaavareDTO laesEnkelRaavareId(int raavareId) throws SQLException {
        return daoRaa.laesEnkelRaavareId(raavareId);
    }
}
