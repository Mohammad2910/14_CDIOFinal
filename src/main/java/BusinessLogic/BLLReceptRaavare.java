package BusinessLogic;

import Core.ReceptRaavareDTO;
import DataAccess.DAO_ReceptRaavare;
import DataAccess.IDAO_ReceptRaavare;

import java.sql.SQLException;
import java.util.List;

public class BLLReceptRaavare implements I_BLLReceptRaavare {
    private IDAO_ReceptRaavare dao_receptRaavare = new DAO_ReceptRaavare();

    @Override
    public List<ReceptRaavareDTO> visReceptRaavare(int receptID) throws SQLException {
        return dao_receptRaavare.visReceptRaavare(receptID);
    }
}

