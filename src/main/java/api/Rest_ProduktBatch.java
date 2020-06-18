package api;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import java.sql.SQLException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("produktbatch")
public class Rest_ProduktBatch implements I_Rest_ProduktBatch{
    I_BLLProduktBatch proBLL = new BLLProduktBatch();

    @Path("opret")
    @POST
    public void opretProduktBatch(String inputs) throws SQLException {

    }

    @Path("vis")
    @POST
    public Response visAlleProduktBatches() throws SQLException {
        return null;
    }

    @Path("visEnkelt")
    @POST
    public Response visEnkelProduktBatch(String inputs) throws SQLException {
        return null;
    }
}
