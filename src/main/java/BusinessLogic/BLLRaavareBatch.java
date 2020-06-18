package BusinessLogic;

import Core.RaavareBatchDTO;
import DataAccess.DAO_RaavareBatch;
import DataAccess.IDAO_RaavareBatch;

import java.sql.SQLException;
import java.util.List;

public class BLLRaavareBatch implements I_BLLRaavareBatch {
    private IDAO_RaavareBatch daoRaaB = new DAO_RaavareBatch();

    @Override
    public void opretRaavareBatch(RaavareBatchDTO enkelRaavareBatch) throws SQLException {
        daoRaaB.opretRaavareBatch(enkelRaavareBatch);
    }

    @Override
    public List<RaavareBatchDTO> visAlleRaavareBatch() throws SQLException {
        return daoRaaB.visAlleRaavareBatches();
    }
}
