package api;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public interface I_Rest_RaavareBatch {

    Response opretRaavareBatch(String raa) throws SQLException;
    Response visAlleRaavareBatches() throws SQLException;

}
