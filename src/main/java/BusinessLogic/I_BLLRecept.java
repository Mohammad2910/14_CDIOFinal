package BusinessLogic;

import Core.ReceptDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLRecept {

    public void opretEnkelRecept(ReceptDTO enkelRecept, int raavareNavnIRecept, double maengde, double tolerance) throws SQLException;

    List<ReceptDTO> visAlleRecepter() throws SQLException;



}
