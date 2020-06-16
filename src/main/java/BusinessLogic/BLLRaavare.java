package BusinessLogic;

import Core.RaavareDTO;
import DataAccess.DAO_Raavare;
import DataAccess.IDAO_Raavare;

import java.sql.SQLException;

public class BLLRaavare implements I_BLLRaavare {
    private IDAO_Raavare daoRaa = new DAO_Raavare();

    @Override
    public RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException {
        return daoRaa.opretEnkelRaavare(enkelRaavare);
    }


    @Override
    public RaavareDTO redigerRaavare(String navn) throws SQLException {
        return null;
    }

    @Override
    public RaavareDTO[] visAlleRaavare() throws SQLException {
        return new RaavareDTO[0];
    }

    @Override
    public RaavareDTO visEnkelRaavareId(int raavareId) throws SQLException {
        return daoRaa.laesEnkelRaavareId(raavareId);
    }
}
