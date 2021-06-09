package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;
import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.services.OfficialService;
import co.edu.unbosque.Hatchiko.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/officers/{username}")
public class OfficersResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Official official, @PathParam("username") String username) {

        Optional<Official> persistedOfficial = new OfficialService().saveOfficial(official, username);

        if (persistedOfficial.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOfficial.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Official user could not be created")
                    .build();
        }
    }
}
