package api;

import javax.xml.ws.Response;
import java.sql.SQLException;

public interface I_Rest_ProduktBatch {

    void opretProduktBatch(String inputs) throws SQLException;
    Response visAlleProduktBatches() throws SQLException;
    Response visEnkelProduktBatch(String inputs) throws SQLException;

}
