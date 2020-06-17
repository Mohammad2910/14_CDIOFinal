package BusinessLogic;

import Core.ReceptDTO;
import DataAccess.DAO_Recept;
import DataAccess.IDAO_Recept;

import java.sql.SQLException;
import java.util.List;

public class BLLRecept implements I_BLLRecept {
    private IDAO_Recept idao_recept = new DAO_Recept();

    @Override
    public void opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException {
        idao_recept.opretEnkelRecept(enkelRecept);
    }

    @Override
    public List<ReceptDTO> visAlleRecepter() throws SQLException {
        return idao_recept.visAlleRecepter();
    }
}
