package BusinessLogic;

import java.sql.SQLException;

public interface I_BLLRecept {

    void opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException;

    List<ReceptDTO> visAlleRecepter() throws SQLException;



}
