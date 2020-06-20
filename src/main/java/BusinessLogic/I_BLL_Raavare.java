package BusinessLogic;

import Core.DTO_Raavare;

import java.sql.SQLException;
import java.util.List;

public interface I_BLL_Raavare {
    DTO_Raavare opretEnkelRaavare(DTO_Raavare enkelRaavare) throws SQLException;

    DTO_Raavare visEnkelRaavareId(int raavareId) throws SQLException;

    void redigerRaavare(DTO_Raavare raavareDTO) throws SQLException;

    List<DTO_Raavare> visAlleRaavare() throws  SQLException;


}
