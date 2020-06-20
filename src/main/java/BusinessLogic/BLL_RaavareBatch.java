package BusinessLogic;

import Core.DTO_RaavareBatch;
import DataAccess.DAO_RaavareBatch;
import DataAccess.IDAO_RaavareBatch;

import java.sql.SQLException;
import java.util.List;

public class BLL_RaavareBatch implements I_BLL_RaavareBatch {
    private IDAO_RaavareBatch daoRaaB = new DAO_RaavareBatch();

    @Override
    public void opretRaavareBatch(DTO_RaavareBatch enkelRaavareBatch) throws SQLException {
        daoRaaB.opretRaavareBatch(enkelRaavareBatch);
    }

    @Override
    public List<DTO_RaavareBatch> visAlleRaavareBatch() throws SQLException {
        return daoRaaB.visAlleRaavareBatches();
    }
}
