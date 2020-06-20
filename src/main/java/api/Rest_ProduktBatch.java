package api;
import BusinessLogic.BLL_ProduktBatch;
import BusinessLogic.I_BLL_ProduktBatch;
import Core.DTO_ProduktBatch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("produktbatch")
public class Rest_ProduktBatch{
    I_BLL_ProduktBatch proBLL = new BLL_ProduktBatch();

    @Path("opret")
    @POST
    public Response opretProduktBatch(String inputs) throws SQLException {
        String[] strarray = inputs.split("&");
        //Lav JavaScripten først
        DTO_ProduktBatch produktBatchDTO = new DTO_ProduktBatch(Integer.parseInt(strarray[0].substring(AttrCount(strarray[0]))),Integer.parseInt(strarray[1].substring(AttrCount(strarray[1]))),"Ikke paabegyndt","",1,1,1);
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
        List<DTO_ProduktBatch> returnRaa;

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
        List<DTO_ProduktBatch> returnRaa;
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
