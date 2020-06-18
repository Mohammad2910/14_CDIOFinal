package api;

import BusinessLogic.BLLRaavare;
import BusinessLogic.BLLRecept;
import BusinessLogic.I_BLLRaavare;
import BusinessLogic.I_BLLRecept;
import Core.RaavareDTO;
import Core.ReceptDTO;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("recept")

public class Rest_Recept {
    I_BLLRecept receptBLL = new BLLRecept();

    @Path("opret")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response opretRecept(@FormParam("receptID") int receptID,  @FormParam("receptNavn") String receptNavn) {
//        String[] strarray = inputs.split("&");
        ReceptDTO receptDTO = new ReceptDTO(receptID, receptNavn);
        try{
            receptBLL.opretEnkelRecept(receptDTO);
        } catch (SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(receptBLL).build();
    }

    @Path("vis")
    @GET
    public Response visAlleRecepter() {
        List<ReceptDTO> returnRaa;
        try{
            returnRaa = receptBLL.visAlleRecepter();
        } catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }


    public static String checkForSpace(String str){
        return str.replace("%20"," ");
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
