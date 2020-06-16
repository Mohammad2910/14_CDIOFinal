package BusinessLogic;

import java.sql.SQLException;

public interface I_BLLProduktBatch {

    ProduktBatchDTO opretEnkelProduktBatch(ProduktBatchDTO enkelProduktBatch) throws SQLException;

    ProduktBatchDTO visEnkelProduktBatch(int produktBatchID) throws SQLException;

    ProduktBatchDTO[] visAlleProduktBatches() throws SQLException;

}
