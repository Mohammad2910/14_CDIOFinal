package DataAccess;

import Core.DTO_ReceptRaavare;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_ReceptRaavare {

    List<DTO_ReceptRaavare> visReceptRaavare(int receptID) throws SQLException;

}
