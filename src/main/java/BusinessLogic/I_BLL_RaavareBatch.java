package BusinessLogic;

import Core.DTO_RaavareBatch;

import java.sql.SQLException;
import java.util.List;

public interface I_BLL_RaavareBatch {
    void opretRaavareBatch(DTO_RaavareBatch enkelRaavareBatch) throws SQLException;


    List<DTO_RaavareBatch> visAlleRaavareBatch() throws SQLException;

}
