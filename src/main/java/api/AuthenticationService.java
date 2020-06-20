package api;

import BusinessLogic.BLL_Bruger;
import BusinessLogic.I_BLL_Bruger;
import Core.DTO_Bruger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


//Jackson processing JSON
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("authentication")
public class AuthenticationService {
    I_BLL_Bruger brugerBLL = new BLL_Bruger();


    @Path("login/{cpr}")
    @POST //post
    public Response login (@PathParam("cpr") String input) {
        DTO_Bruger returnBru;
        try {
            System.out.println(input);
            returnBru = brugerBLL.visEnkelBruger(input);

        } catch (SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }

        return Response.ok(returnBru).build();
    }

}
