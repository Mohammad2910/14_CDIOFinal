package BusinessLogic;

import java.sql.SQLException;

public class BLLRecept implements I_BLLRecept {
    private IDAO_Recept idao_recept = new IDAO_Recept;

    @Override
    public void opretEnkelRecept(ReceptDTO enkelRecept) throws SQLException {
        idao_recept.opretEnkelRecept();
    }

    @Override
    public List<ReceptDTO> visAlleRecepter() throws SQLException {
        return idao_recept.visAlleRecepter();
    }
}
