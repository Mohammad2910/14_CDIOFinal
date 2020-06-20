package DataAccess;

import Core.DTO_RaavareBatch;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_RaavareBatch {

    void opretRaavareBatch(DTO_RaavareBatch raavareBatchDTO) throws SQLException;
    List<DTO_RaavareBatch> visAlleRaavareBatches() throws SQLException;

}
