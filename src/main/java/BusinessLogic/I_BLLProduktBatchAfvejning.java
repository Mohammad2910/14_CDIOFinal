package BusinessLogic;

import java.sql.SQLException;

public interface I_BLLProduktBatchAfvejning {
    ProduktBatchAfvejningDTO opretEnkelProduktBatchAfvejning(ProduktBatchAfvejningDTO enkelProduktBatchAfvejning) throws SQLException;

    ProduktBatchAfvejningDTO[] visAlleProduktBatchAfvejninger(int produktBatchID) throws SQLException;

}
