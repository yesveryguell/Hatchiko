package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets/{username}")
public class VetsResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Vet vet, @PathParam("username") String username) {

        Optional<Vet> persistedVet = new VetService().saveVet(vet, username);

        if (persistedVet.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVet.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Vet user could not be created")
                    .build();
        }
    }
}
