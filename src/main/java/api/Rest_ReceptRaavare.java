package api;

import BusinessLogic.BLLReceptRaavare;
import BusinessLogic.I_BLLReceptRaavare;
import Core.ReceptRaavareDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("receptRaavare")

public class Rest_ReceptRaavare implements I_Rest_ReceptRaavare{
    private I_BLLReceptRaavare receptRaavareBLL = new BLLReceptRaavare();

    @Path("vis")
    @POST
    public Response visReceptRaavare(String inputs) {
        String[] str = inputs.split("&");
        List<ReceptRaavareDTO> returnRaa;
        try{
            returnRaa = receptRaavareBLL.visReceptRaavare(Integer.parseInt(str[2].substring(AttrCount(str[2]))));
        } catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }

    public static int AttrCount(String attr){
        int count = 0;
        for (int i = 0; i < attr.length(); i++) {
            if(attr.charAt(i) == '='){
                break;
            }
            count++;
        }
        return ++count;
    }

}
