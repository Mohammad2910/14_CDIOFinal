package api;

import BusinessLogic.BLL_Bruger;
import BusinessLogic.I_BLL_Bruger;
import Core.DTO_Bruger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("bruger")
public class Rest_Bruger {
    I_BLL_Bruger brugerBLL = new BLL_Bruger();

    @Path("opret")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response opretBruger(@FormParam("brugerCpr") String brugerCpr, @FormParam("brugerNavn") String brugerNavn,@FormParam("brugerIni") String brugerIni,@FormParam("brugerRolle") String brugerRolle,@FormParam("brugerStatus") String brugerStatus) {
        DTO_Bruger brugerDTO = new DTO_Bruger(brugerCpr, brugerNavn, brugerIni, brugerRolle, brugerStatus);
        DTO_Bruger returnBru;
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
        List<DTO_Bruger> returnBru;
        try{
            returnBru = brugerBLL.visAlleBrugere();
        }catch (SQLException e){
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok(returnBru).build();
    }

    @Path("slet")
    @POST
    public Response sletBruger(String cpr) {
        String[] strarray = cpr.split("&");
        //Lav JavaScripten først


        try{
            brugerBLL.sletBruger(strarray[0].substring(AttrCount(strarray[0])));
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @Path("rediger")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response redigerBruger(@FormParam("brugerCpr") String brugerCpr, @FormParam("brugerNavn") String brugerNavn,@FormParam("brugerIni") String brugerIni,@FormParam("brugerRolle") String brugerRolle,@FormParam("brugerStatus") String brugerStatus){
        DTO_Bruger brugerDTO = new DTO_Bruger(brugerCpr,brugerNavn,brugerIni,brugerRolle,brugerStatus);
        try{
            brugerBLL.redigerBruger(brugerDTO);
        } catch(SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }
        return Response.ok().build();
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


