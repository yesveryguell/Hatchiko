package co.edu.unbosque.Hatchiko.resource;
import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Path("/owners/{username}")
public class OwnerUploadResource {


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("userName") String userName, OwnerPojo ownerPojo) {
        Optional<Owner> persistedOwner = new OwnerService().modifyOwner(userName,ownerPojo);


        return Response.ok()
                .entity(persistedOwner.get())
                .build();
    }

}
