package api;

//root path for API services

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class ApiConfig extends ResourceConfig{

}
