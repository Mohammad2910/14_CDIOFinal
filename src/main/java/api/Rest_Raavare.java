package api;

import BusinessLogic.BLLRaavare;
import BusinessLogic.I_BLLRaavare;
import Core.RaavareDTO;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;
import java.sql.SQLException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("raavare")

public class Rest_Raavare implements I_Rest_Raavare {
    I_BLLRaavare raavareBLL = new BLLRaavare();

    @Path("opret")
    @POST
    public void opretRaavare(String inputs) {
        String[] strarray = inputs.split("&");
        RaavareDTO raavareDTO = new RaavareDTO(Integer.parseInt(strarray[0].substring(10)),strarray[1].substring(12));
        RaavareDTO returnRaa;
        try{
            //returnRaa =
            raavareBLL.opretEnkelRaavare(raavareDTO);

        } catch (SQLException e) {
            //return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        //return Response.ok(returnRaa).build();
    }

    @Path("vis")
    @GET
    public Response visRaavare(int raavareId) {

        RaavareDTO returnRaa;
        try{
            returnRaa = raavareBLL.laesEnkelRaavareId(raavareId);

        } catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }
}
