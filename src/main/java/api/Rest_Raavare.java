package api;

import BusinessLogic.BLLRaavare;
import BusinessLogic.I_BLLRaavare;
import Core.RaavareDTO;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("raavare")

public class Rest_Raavare {
    I_BLLRaavare raavareBLL = new BLLRaavare();

    @Path("opret")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response opretRaavare(@FormParam("raavareId") int raavareId,  @FormParam("raavareNavn") String raavareNavn) {
        RaavareDTO raavareDTO = new RaavareDTO(raavareId,raavareNavn);
        RaavareDTO returnRaa;
        try{
            returnRaa = raavareBLL.opretEnkelRaavare(raavareDTO);

        } catch (SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }

    @Path("vis")
    @GET
    public Response visAlleRaavare() {
        List<RaavareDTO> returnRaa;

        try{
            returnRaa = raavareBLL.visAlleRaavare();
        } catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }

    @Path("vis/{id}")
    @GET
    public Response visRaavare(@PathParam("id") int raavareId) {
        System.out.println(raavareId);
        RaavareDTO returnRaa;
        try{
            returnRaa = raavareBLL.visEnkelRaavareId(raavareId);

        } catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }

    @Path("rediger")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void redigerRaavare(@FormParam("raavareId") int retRaavareID,  @FormParam("raavareNavn") String retRaavareNavn) {
       // String[] strarray = inputs.split("&");
        RaavareDTO raavareDTO = new RaavareDTO(retRaavareID, retRaavareNavn);
        System.out.println(raavareDTO);
        RaavareDTO returnRaa;
        try{
            //returnRaa =
            raavareBLL.redigerRaavare(raavareDTO);

        } catch (SQLException e) {

        }

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
