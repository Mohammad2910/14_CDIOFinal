package BusinessLogic;

import Core.ProduktBatchDTO;
import java.sql.SQLException;
import java.util.List;

public interface I_BLLProduktBatch {
    void opretProduktBatch(ProduktBatchDTO enkelProduktBatch) throws SQLException;

    List<ProduktBatchDTO> visAlleProduktBatches() throws SQLException;

    List<ProduktBatchDTO> visEnkelProduktBatch(int produktBatchID) throws SQLException;


}
