package api;

import BusinessLogic.BLLRaavareBatch;
import BusinessLogic.I_BLLRaavareBatch;
import Core.RaavareBatchDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("raavarebatch")
public class Rest_RaavareBatch{
    I_BLLRaavareBatch raaBLL = new BLLRaavareBatch();


    @Path("opret")
    @POST
    public Response opretRaavareBatch(String raa) throws SQLException {
        String[] strarray = raa.split("&");
        //Lav JavaScripten først
        RaavareBatchDTO raavareBatchDTO = new RaavareBatchDTO(Integer.parseInt(strarray[0].substring(AttrCount(strarray[0]))),Double.parseDouble(strarray[1].substring(AttrCount(strarray[1]))),strarray[2].substring(AttrCount(strarray[2])),Integer.parseInt(strarray[3].substring(AttrCount(strarray[3]))));
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
        List<RaavareBatchDTO> returnRaa;
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
