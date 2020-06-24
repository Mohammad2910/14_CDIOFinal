package BusinessLogic;

import Core.DTO_Afvejning;
import Core.DTO_Tomafvejning;
import DataAccess.DAO_Afvejning;
import DataAccess.IDAO_Afvejning;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BLL_Afvejning implements I_BLL_Afvejning {
    private IDAO_Afvejning daoAfvejning = new DAO_Afvejning();

    @Override
    public void opretEnkeltAfvejning(DTO_Afvejning afvejning, double kontrol) throws SQLException {
        if (kontrol-afvejning.getTara() > 0.2){throw new SQLException();}
        daoAfvejning.opretEnkeltAfvejning(afvejning);
    }

    @Override
    public List<DTO_Afvejning> visEnkeltAfvejning(int produktBatchID) throws SQLException {
        return daoAfvejning.visEnkeltAfvejning(produktBatchID);
    }

    @Override
    public List<DTO_Tomafvejning> visTomAfvejning(int produktBatchID) throws SQLException {
        return daoAfvejning.visTomAfvejning(produktBatchID);
    }
}
