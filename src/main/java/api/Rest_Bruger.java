package api;

import BusinessLogic.BLLBruger;
import BusinessLogic.I_BLLBruger;
import Core.BrugerDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("bruger")
public class Rest_Bruger implements I_Rest_Bruger {
    I_BLLBruger brugerBLL = new BLLBruger();

    @Path("opret")
    @POST
    public Response opretBruger(String inputs) {
        String[] strarray = inputs.split("&");
       //Lav JavaScripten først
        BrugerDTO brugerDTO = new BrugerDTO(strarray[0].substring(AttrCount(strarray[0])),checkForSpace(strarray[1].substring(AttrCount(strarray[1]))),strarray[2].substring(AttrCount(strarray[2])),strarray[3].substring(AttrCount(strarray[3])),strarray[4].substring(AttrCount(strarray[4])));

        BrugerDTO returnBru;
        try{
            returnBru = brugerBLL.opretEnkelBruger(brugerDTO);
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnBru).build();
    }
    @Path("vis")
    @GET
    public Response visAlleBrugere(){
        List<BrugerDTO> returnBru;
        try{
            returnBru = brugerBLL.visAlleBrugere();
        }catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnBru).build();
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


