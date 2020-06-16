package DataAccess;

import Core.RaavareDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_DAL_Raavare {
    RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException;
    RaavareDTO laesEnkelRaavareId(int raavareId) throws SQLException;
}