package BusinessLogic;

import Core.DTO_ReceptRaavare;
import DataAccess.DAO_ReceptRaavare;
import DataAccess.IDAO_ReceptRaavare;

import java.sql.SQLException;
import java.util.List;

public class BLL_ReceptRaavare implements I_BLL_ReceptRaavare {
    private IDAO_ReceptRaavare dao_receptRaavare = new DAO_ReceptRaavare();

    @Override
    public List<DTO_ReceptRaavare> visReceptRaavare(int receptID) throws SQLException {
        return dao_receptRaavare.visReceptRaavare(receptID);
    }
}

