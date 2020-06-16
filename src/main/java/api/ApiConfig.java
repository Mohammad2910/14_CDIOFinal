package api;

//root path for API services


import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApiConfig extends Application {

}