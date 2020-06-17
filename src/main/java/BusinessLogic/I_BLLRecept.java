package BusinessLogic;

import Core.ReceptDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLRecept {

    void opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException;

    List<ReceptDTO> visAlleRecepter() throws SQLException;



}
