package api;

import Core.ReceptRaavareDTO;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public interface I_Rest_ReceptRaavare {
     Response visAlleReceptRaavarer(String inputs) throws SQLException;
}
