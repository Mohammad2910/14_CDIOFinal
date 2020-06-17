package BusinessLogic;

import Core.RaavareDTO;
import DataAccess.DAO_Raavare;
import DataAccess.IDAO_Raavare;

import java.sql.SQLException;
import java.util.List;

public class BLLRaavare implements I_BLLRaavare {
    private IDAO_Raavare daoRaa = new DAO_Raavare();

    @Override
    public RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException {
        return daoRaa.opretEnkelRaavare(enkelRaavare);
    }


    @Override
    public RaavareDTO redigerRaavare(RaavareDTO enkelRaavare) throws SQLException {
        return null;
    }

    @Override
    public List<RaavareDTO> visAlleRaavare() throws SQLException {
        return daoRaa.visAlleRaavare();
    }

    @Override
    public RaavareDTO visEnkelRaavareId(int raavareId) throws SQLException {
        return daoRaa.laesEnkelRaavareId(raavareId);
    }
}
