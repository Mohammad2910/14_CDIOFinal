package BusinessLogic;

import java.sql.SQLException;
import java.util.List;

public class BLLReceptRaavare implements I_BLLReceptRaavare {
    private IDAO_ReceptRaavare dao_receptRaavare = new DAO_ReceptRaavare();

    @Override
    public List<ReceptRaavareDTO> visReceptRaavare(String receptID) throws SQLException {
        return dao_receptRaavare.visAlleReceptRaavarer(receptID);
    }
}

