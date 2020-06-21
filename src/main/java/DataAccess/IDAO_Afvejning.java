package DataAccess;

import Core.DTO_Afvejning;
import Core.DTO_Tomafvejning;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_Afvejning {
    void opretEnkeltAfvejning(DTO_Afvejning afvejning) throws SQLException;
    List<DTO_Afvejning> visEnkeltAfvejning(int produktBatchID) throws SQLException;
    List<DTO_Tomafvejning> visTomAfvejning(int produktBatchID) throws SQLException;
}
