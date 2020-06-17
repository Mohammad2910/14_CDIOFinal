package DataAccess;

import Core.ReceptRaavareDTO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_ReceptRaavare {

    List<ReceptRaavareDTO> visReceptRaavare(int receptID) throws SQLException;

}
