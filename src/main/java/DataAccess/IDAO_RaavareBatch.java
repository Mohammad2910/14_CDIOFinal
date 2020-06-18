package DataAccess;

import Core.RaavareBatchDTO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_RaavareBatch {

    void opretRaavareBatch(RaavareBatchDTO raavareBatchDTO) throws SQLException;
    List<RaavareBatchDTO> visAlleRaavareBatches() throws SQLException;

}
