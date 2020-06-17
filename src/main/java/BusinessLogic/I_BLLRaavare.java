package BusinessLogic;

import Core.RaavareDTO;

import java.sql.SQLException;
import java.util.List;

public interface I_BLLRaavare {
    RaavareDTO opretEnkelRaavare(RaavareDTO enkelRaavare) throws SQLException;

    RaavareDTO visEnkelRaavareId(int raavareId) throws SQLException;

    RaavareDTO redigerRaavare(RaavareDTO raavareDTO) throws SQLException;

    List<RaavareDTO> visAlleRaavare() throws  SQLException;


}
