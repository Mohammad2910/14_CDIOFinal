package BusinessLogic;

import Core.DTO_Afvejning;
import Core.DTO_Tomafvejning;

import java.sql.SQLException;
import java.util.List;

public interface I_BLL_Afvejning {
    void opretEnkeltAfvejning(DTO_Afvejning afvejning, double kontrol) throws SQLException;
    List<DTO_Afvejning> visEnkeltAfvejning(int produktBatchID) throws SQLException;
    List<DTO_Tomafvejning> visTomAfvejning(int produktBatchID) throws SQLException;
}
