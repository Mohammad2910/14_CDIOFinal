package BusinessLogic;

import Core.DTO_Recept;

import java.sql.SQLException;
import java.util.List;

public interface I_BLL_Recept {

    public void opretEnkelRecept(DTO_Recept enkelRecept, int raavareNavnRecept, double maengde, double tolerance) throws SQLException;

    List<DTO_Recept> visAlleRecepter() throws SQLException;



}
