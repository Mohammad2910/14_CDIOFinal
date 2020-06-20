package BusinessLogic;

import Core.DTO_Recept;
import DataAccess.DAO_Recept;
import DataAccess.IDAO_Recept;

import java.sql.SQLException;
import java.util.List;

public class BLL_Recept implements I_BLL_Recept {
    private IDAO_Recept idao_recept = new DAO_Recept();

    @Override
    public void opretEnkelRecept(DTO_Recept enkelRecept, int raavareNavnRecept, double maengde, double tolerance) throws SQLException {
        idao_recept.opretEnkelRecept(enkelRecept, raavareNavnRecept, maengde, tolerance);
    }

    @Override
    public List<DTO_Recept> visAlleRecepter() throws SQLException {
        return idao_recept.visAlleRecepter();
    }
}
