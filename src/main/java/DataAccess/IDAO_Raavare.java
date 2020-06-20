package DataAccess;

import Core.DTO_Raavare;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_Raavare {
    DTO_Raavare opretEnkelRaavare(DTO_Raavare enkelRaavare) throws SQLException;
    DTO_Raavare laesEnkelRaavareId(int raavareID) throws SQLException;
    List<DTO_Raavare> visAlleRaavare() throws SQLException;
    void redigerRaavare(DTO_Raavare nyRaavare) throws SQLException;


}
