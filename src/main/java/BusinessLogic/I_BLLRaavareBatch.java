package BusinessLogic;

import java.sql.SQLException;

public interface I_BLLRaavareBatch {
    RaavareBatchDTO opretEnkelRaavareBatch(RaavareBatchDTO enkelRaavareBatch) throws SQLException;

    RaavareBatchDTO visEnkelRaavareBatch(int raavareBatchID) throws SQLException;

    RaavareBatchDTO[] visAlleRaavareBatch() throws SQLException;

}
