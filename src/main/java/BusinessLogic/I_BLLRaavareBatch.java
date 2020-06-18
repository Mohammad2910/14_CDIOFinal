package BusinessLogic;

import Core.RaavareBatchDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLRaavareBatch {
    void opretRaavareBatch(RaavareBatchDTO enkelRaavareBatch) throws SQLException;


    List<RaavareBatchDTO> visAlleRaavareBatch() throws SQLException;

}
