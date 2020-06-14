package api;

import Core.RaavareDTO;

import javax.ws.rs.core.Response;

public interface I_Rest_Raavare {
    Response opretRaavare(RaavareDTO raa);
}
