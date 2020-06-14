package api;

import BusinessLogic.BLLRaavare;
import BusinessLogic.I_BLLRaavare;
import Core.RaavareDTO;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("raavare")

public class Rest_Raavare implements I_Rest_Raavare {
    I_BLLRaavare raavareBLL = new BLLRaavare();

    @Path("opret")
    @POST
    public Response opretRaavare(RaavareDTO raa) {
        System.out.println(raa);

        RaavareDTO returnRaa;
        try{
            returnRaa = raavareBLL.opretEnkelRaavare(raa);

        } catch (SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }
}
