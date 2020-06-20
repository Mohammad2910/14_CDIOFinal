package BusinessLogic;

import Core.DTO_ProduktBatch;
import DataAccess.DAO_ProduktBatch;
import DataAccess.IDAO_ProduktBatch;

import java.sql.SQLException;
import java.util.List;

public class BLL_ProduktBatch implements I_BLL_ProduktBatch {
    private IDAO_ProduktBatch daoProB = new DAO_ProduktBatch();

    @Override
    public void opretProduktBatch(DTO_ProduktBatch enkelProduktBatch) throws SQLException {
        daoProB.opretProduktBatch(enkelProduktBatch);
    }

    @Override
    public List<DTO_ProduktBatch> visAlleProduktBatches() throws SQLException {
        return daoProB.visAlleProduktBatches();
    }

    @Override
    public List<DTO_ProduktBatch> visEnkelProduktBatch(int produktBatchID) throws SQLException {
        return daoProB.visEnkelProduktBatch(produktBatchID);
    }
}
