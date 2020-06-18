package BusinessLogic;

import java.sql.SQLException;

public class BLLRaavareBatch implements I_BLLRaavareBatch {
    private IDAO_RaavareBatch daoRaaB = new DAO_RaavareBatch();

    @Override
    public void opretEnkelRaavareBatch(RaavareBatchDTO enkelRaavareBatch) throws SQLException {
        daoRaaB.opretEnkelRaavareBatch(enkelRaavareBatch);
    }

    @Override
    public RaavareBatchDTO visEnkelRaavareBatch(int raavareBatchID) throws SQLException {
        return daoRaaB.visEnkelRaavareBatch(raavareBatchID);
    }

    @Override
    public List<RaavareBatchDTO> visAlleRaavareBatch() throws SQLException {
        return daoRaaB.visAlleRaavareBatches();
    }
}
