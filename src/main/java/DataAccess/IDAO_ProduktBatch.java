package DataAccess;

import Core.ProduktBatchDTO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_ProduktBatch {

    void opretProduktBatch(ProduktBatchDTO produktBatchDTO) throws SQLException;
    List<ProduktBatchDTO> visAlleProduktBatches() throws SQLException;
    List<ProduktBatchDTO> visEnkelProduktBatch(int produktBatchID) throws SQLException;

}
