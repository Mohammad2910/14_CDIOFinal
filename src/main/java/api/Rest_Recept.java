package api;

import BusinessLogic.BLL_Recept;
import BusinessLogic.I_BLL_Recept;
import Core.DTO_Recept;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("recept")

public class Rest_Recept {
    I_BLL_Recept receptBLL = new BLL_Recept();

    @Path("opret")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response opretRecept(@FormParam("receptID") int receptID,  @FormParam("receptNavn") String receptNavn,
                                @FormParam("raavareNavnRecept") int raavareNavnRecept, @FormParam("raavareMaengde")
                                double raavareMaengde, @FormParam("tolerance") double tolerance) {
//        String[] strarray = inputs.split("&");
        DTO_Recept receptDTO = new DTO_Recept(receptID, receptNavn);
        System.out.println(receptID + receptNavn);
        try{
            receptBLL.opretEnkelRecept(receptDTO, raavareNavnRecept, raavareMaengde, tolerance);
        } catch (SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @Path("vis")
    @GET
    public Response visAlleRecepter() {
        List<DTO_Recept> returnRaa;
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
