package api;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public interface I_Rest_ProduktBatch {

    Response opretProduktBatch(String inputs) throws SQLException;
    Response visAlleProduktBatches() throws SQLException;
    Response visEnkelProduktBatch(String inputs) throws SQLException;

}
