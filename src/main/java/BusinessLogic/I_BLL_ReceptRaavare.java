package BusinessLogic;

import Core.DTO_ReceptRaavare;

import java.sql.SQLException;
import java.util.List;

public interface I_BLL_ReceptRaavare {
    List<DTO_ReceptRaavare> visReceptRaavare(int receptID) throws SQLException;
}
