package BusinessLogic;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLReceptRaavare {
    List<ReceptRaavareDTO> visReceptRaavare(String receptID) throws SQLException;
}
