package BusinessLogic;

import Core.RaavareDTO;

import java.sql.SQLException;

public interface I_BLLRaavare {
    RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException;

    RaavareDTO laesEnkelRaavareId(int raavareId) throws SQLException;

}
