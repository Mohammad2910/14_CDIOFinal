package BusinessLogic;

import Core.ReceptRaavareDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLReceptRaavare {
    List<ReceptRaavareDTO> visAlleReceptRaavarer(String receptID) throws SQLException;
}
