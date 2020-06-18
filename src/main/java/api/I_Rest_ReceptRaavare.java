package api;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public interface I_Rest_ReceptRaavare {
     Response visReceptRaavare(String inputs) throws SQLException;
}
