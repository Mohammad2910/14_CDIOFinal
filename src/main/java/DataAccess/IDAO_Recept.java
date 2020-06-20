package DataAccess;

import Core.DTO_Recept;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_Recept {

    void opretEnkelRecept(DTO_Recept enkelRecept, int a, double b, double c) throws SQLException;
    List<DTO_Recept> visAlleRecepter() throws SQLException;

}
