package BusinessLogic;

import Core.ReceptRaavareDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLReceptRaavare {
    List<ReceptRaavareDTO> visReceptRaavare(int receptID) throws SQLException;
}
