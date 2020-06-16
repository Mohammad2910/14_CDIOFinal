package BusinessLogic;

import java.sql.SQLException;

public interface I_BLLRecept {

    ReceptDTO opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException;

    ReceptDTO visEnkelRecept(int receptID) throws SQLException;

    ReceptDTO[] visAlleRecepter() throws SQLException;



}
