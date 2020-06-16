package BusinessLogic;

import Core.RaavareDTO;

import java.sql.SQLException;

public interface I_BLLRaavare {
    RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException;

    RaavareDTO visEnkelRaavareId(int raavareId) throws SQLException;

    RaavareDTO redigerRaavare(String navn) throws SQLException;

    RaavareDTO[] visAlleRaavare() throws  SQLException;


}
