package DataAccess;

import Core.ProduktBatchDTO;

import java.sql.SQLException;
import java.util.List;

public class DAO_ProduktBatch implements IDAO_ProduktBatch {
    @Override
    public void opretProduktBatch(ProduktBatchDTO produktBatchDTO) throws SQLException {

    }

    @Override
    public List<ProduktBatchDTO> visAlleProduktBatches() throws SQLException {
        return null;
    }

    @Override
    public List<ProduktBatchDTO> visEnkelProduktBatch(int produktBatchID) throws SQLException {
        return null;
    }
}
