package api;

import controller.AuthenticationController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("authentication")
//Jackson processing JSON
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationService {
    @Context
    ContainerRequestContext containerRequestContext;

    private AuthenticationController authenticationController = ControllerRegistry.getAuthenticationController;

    @Path("login")
    @POST
    public String login (LoginDetails loginDetails) {
        return authenticationController.login(loginDetails);
    }

}
