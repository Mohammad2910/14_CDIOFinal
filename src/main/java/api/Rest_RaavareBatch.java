package api;

import BusinessLogic.BLL_RaavareBatch;
import BusinessLogic.I_BLL_RaavareBatch;
import Core.DTO_RaavareBatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("raavarebatch")
public class Rest_RaavareBatch{
    I_BLL_RaavareBatch raaBLL = new BLL_RaavareBatch();


    @Path("opret")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response opretRaavareBatch(@FormParam("raavarebatchNummer") int raavarebatchNummer, @FormParam("raavarebatchMaengde") double raavarebatchMaengde, @FormParam("raavarebatchLeverandoer") String raavarebatchLeverandoer, @FormParam("raavarebatchRaavareID") int raavarebatchRaavareID) throws SQLException {
        DTO_RaavareBatch raavareBatchDTO = new DTO_RaavareBatch(raavarebatchNummer,raavarebatchMaengde,raavarebatchLeverandoer,raavarebatchRaavareID);
        try{
            raaBLL.opretRaavareBatch(raavareBatchDTO);
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @Path("vis")
    @POST
    public Response visAlleRaavareBatches() throws SQLException {
        List<DTO_RaavareBatch> returnRaa;
        try{
            returnRaa = raaBLL.visAlleRaavareBatch();
        } catch(SQLException e) {
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
