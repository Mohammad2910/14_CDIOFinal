package api;

import BusinessLogic.BLL_Afvejning;
import BusinessLogic.BLL_Bruger;
import BusinessLogic.I_BLL_Afvejning;
import BusinessLogic.I_BLL_Bruger;
import Core.DTO_Afvejning;
import Core.DTO_Bruger;
import Core.DTO_Tomafvejning;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("afvejning")
public class Rest_Afvejning {
    I_BLL_Afvejning afvejningBLL = new BLL_Afvejning();

    @Path("opret")
    @POST
    public Response opretEnkeltAfvejning(String inputs) {
        String[] strarray = inputs.split("&");
        //Lav JavaScripten først
        DTO_Afvejning dto_afvejning = new DTO_Afvejning(Double.parseDouble(strarray[1].substring(AttrCount(strarray[1]))),Double.parseDouble(strarray[3].substring(AttrCount(strarray[3]))),Integer.parseInt(strarray[2].substring(AttrCount(strarray[2]))),strarray[4].substring(AttrCount(strarray[4])),Integer.parseInt(strarray[0].substring(AttrCount(strarray[0]))),"");
        try{
            afvejningBLL.opretEnkeltAfvejning(dto_afvejning, Double.parseDouble(strarray[5].substring(AttrCount(strarray[5]))));
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @Path("vis")
    @POST
    public Response visEnkeltAfvejning(String inputs){
        String[] strarray = inputs.split("&");
        List<DTO_Afvejning> returnAfv;
        try{
            returnAfv = afvejningBLL.visEnkeltAfvejning(Integer.parseInt(strarray[4].substring(AttrCount(strarray[4]))));
        }catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnAfv).build();
    }

    @Path("vistomme")
    @POST
    public Response visTomAfvejning(String inputs){
        String[] strarray = inputs.split("&");
        List<DTO_Tomafvejning> returnAfv;
        try{
            returnAfv = afvejningBLL.visTomAfvejning(Integer.parseInt(strarray[0].substring(AttrCount(strarray[0]))));
        }catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnAfv).build();
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
