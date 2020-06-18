package api;

import javax.xml.ws.Response;
import java.sql.SQLException;

public interface I_Rest_RaavareBatch {

    void opretRaavareBatch(String raa) throws SQLException;
    Response visAlleRaavareBatches() throws SQLException;

}
