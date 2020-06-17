package DataAccess;

import Core.ReceptDTO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_Recept {

    void opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException;
    List<ReceptDTO> visAlleRecepter() throws SQLException;

}
