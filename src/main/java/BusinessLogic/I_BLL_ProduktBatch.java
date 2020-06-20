package BusinessLogic;

import Core.DTO_ProduktBatch;
import java.sql.SQLException;
import java.util.List;

public interface I_BLL_ProduktBatch {
    void opretProduktBatch(DTO_ProduktBatch enkelProduktBatch) throws SQLException;

    List<DTO_ProduktBatch> visAlleProduktBatches() throws SQLException;

    List<DTO_ProduktBatch> visEnkelProduktBatch(int produktBatchID) throws SQLException;


}
