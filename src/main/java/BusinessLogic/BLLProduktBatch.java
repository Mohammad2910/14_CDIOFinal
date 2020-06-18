package BusinessLogic;

import Core.ProduktBatchDTO;
import DataAccess.DAO_ProduktBatch;
import DataAccess.IDAO_ProduktBatch;

import java.sql.SQLException;
import java.util.List;

public class BLLProduktBatch implements I_BLLProduktBatch {
    private IDAO_ProduktBatch daoProB = new DAO_ProduktBatch();

    @Override
    public void opretProduktBatch(ProduktBatchDTO enkelProduktBatch) throws SQLException {
        daoProB.opretProduktBatch(enkelProduktBatch);
    }

    @Override
    public List<ProduktBatchDTO> visAlleProduktBatches() throws SQLException {
        return daoProB.visAlleProduktBatches();
    }

    @Override
    public List<ProduktBatchDTO> visEnkelProduktBatch(int produktBatchID) throws SQLException {
        return daoProB.visEnkelProduktBatch(produktBatchID);
    }
}
