package BusinessLogic;

import java.sql.SQLException;

public interface I_BLLRaavareBatch {
    void opretEnkelRaavareBatch(RaavareBatchDTO enkelRaavareBatch) throws SQLException;

    RaavareBatchDTO visEnkelRaavareBatch(int raavareBatchID) throws SQLException;

    List<RaavareBatchDTO> visAlleRaavareBatch() throws SQLException;

}
