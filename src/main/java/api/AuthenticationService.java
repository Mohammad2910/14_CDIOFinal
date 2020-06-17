package api;

import BusinessLogic.BLLBruger;
import BusinessLogic.I_BLLBruger;
import Core.BrugerDTO;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


//Jackson processing JSON
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("authentication")
public class AuthenticationService {
    I_BLLBruger brugerBLL = new BLLBruger();


    @Path("login/{cpr}")
    @GET
    public Response login (@PathParam("cpr") String input) {
        BrugerDTO returnBru;
        try {
            System.out.println(input);
            returnBru = brugerBLL.visEnkelBruger(input);

//            switch (returnBru.getRoller()){
//                case "admin": jkaskjhf;
//                break;
//                case "produktionsleder": jdahfklajdhs;
//                break;
//                case "laborant": kjhafdjkhf;
//                break;
//                case "farmaceut": jahdsfh;
//                break;
//                default: lkjfalsj;
//                break;
//            }
        } catch (SQLException e) {
            return Response.status(400).entity("SQLException: " + e.getMessage()).build();
        }

        return Response.ok(returnBru).build();
    }

}
