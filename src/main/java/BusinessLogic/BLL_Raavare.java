package BusinessLogic;

import Core.DTO_Raavare;
import DataAccess.DAO_Raavare;
import DataAccess.IDAO_Raavare;

import java.sql.SQLException;
import java.util.List;

public class BLL_Raavare implements I_BLL_Raavare {
    private IDAO_Raavare daoRaa = new DAO_Raavare();

    @Override
    public DTO_Raavare opretEnkelRaavare(DTO_Raavare enkelRaavare) throws SQLException {
        return daoRaa.opretEnkelRaavare(enkelRaavare);
    }


    @Override
    public void redigerRaavare(DTO_Raavare enkelRaavare) throws SQLException {
        daoRaa.redigerRaavare(enkelRaavare);
    }

    @Override
    public List<DTO_Raavare> visAlleRaavare() throws SQLException {
        return daoRaa.visAlleRaavare();
    }

    @Override
    public DTO_Raavare visEnkelRaavareId(int raavareId) throws SQLException {
        return daoRaa.laesEnkelRaavareId(raavareId);
    }
}
