package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners/{id}/pets")
public class PetsResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pet pet, @PathParam("id") Integer id) {

        Optional<Pet> persistedPet = new PetService().savePet(pet, id);

        if (persistedPet.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedPet.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }
    }
}
