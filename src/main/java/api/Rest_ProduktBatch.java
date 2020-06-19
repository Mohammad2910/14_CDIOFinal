package api;
import BusinessLogic.BLLProduktBatch;
import BusinessLogic.I_BLLProduktBatch;
import Core.ProduktBatchDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("produktbatch")
public class Rest_ProduktBatch implements I_Rest_ProduktBatch{
    I_BLLProduktBatch proBLL = new BLLProduktBatch();

    @Path("opret")
    @POST
    public Response opretProduktBatch(String inputs) throws SQLException {
        String[] strarray = inputs.split("&");
        //Lav JavaScripten først
        ProduktBatchDTO produktBatchDTO = new ProduktBatchDTO(Integer.parseInt(strarray[0].substring(AttrCount(strarray[0]))),Integer.parseInt(strarray[1].substring(AttrCount(strarray[1]))),"Ikke paabegyndt","",1,1,1);
        try{
            proBLL.opretProduktBatch(produktBatchDTO);
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @Path("vis")
    @POST
    public Response visAlleProduktBatches() throws SQLException {
        List<ProduktBatchDTO> returnRaa;

        try{
            returnRaa = proBLL.visAlleProduktBatches();
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnRaa).build();
    }

    @Path("visEnkelt")
    @POST
    public Response visEnkelProduktBatch(String inputs) throws SQLException {
        String[] str = inputs.split("&");
        List<ProduktBatchDTO> returnRaa;
        try{
            returnRaa = proBLL.visEnkelProduktBatch(Integer.parseInt(str[0].substring(AttrCount(str[0]))));
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
