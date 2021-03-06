package DataAccess;

import Core.DTO_ProduktBatch;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_ProduktBatch {

    void opretProduktBatch(DTO_ProduktBatch produktBatchDTO) throws SQLException;
    List<DTO_ProduktBatch> visAlleProduktBatches() throws SQLException;
    List<DTO_ProduktBatch> visEnkelProduktBatch(int produktBatchID) throws SQLException;

}
