package api;

import javax.xml.ws.Response;
import java.sql.SQLException;

public class Rest_RaavareBatch implements I_Rest_RaavareBatch {
    @Override
    public void opretRaavareBatch(String raa) throws SQLException {
    }

    @Override
    public Response visAlleRaavareBatches() throws SQLException {
        return null;
    }
}
