package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.resource.filters.Logged;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.UserAppService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Optional;

@Path("/owners")
public class OwnerResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OwnerPojo ownerPojo) {

        Optional<OwnerPojo> persistedOwner = new OwnerService().saveOwner(ownerPojo);

        if (persistedOwner.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOwner.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }


    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"Owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
}
