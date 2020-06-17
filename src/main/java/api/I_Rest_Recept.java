package api;

import javax.ws.rs.core.Response;

public interface I_Rest_Recept {
    Response opretRecept(String raa);
    Response visAlleRecepter();
}
