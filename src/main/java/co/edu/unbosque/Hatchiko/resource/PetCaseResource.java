package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;
import co.edu.unbosque.Hatchiko.resource.pojos.PetCasePojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitPojo;
import co.edu.unbosque.Hatchiko.services.PetCaseService;
import co.edu.unbosque.Hatchiko.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners/{username}/pet/{pet_id}/petCases")
public class PetCaseResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePojo petCasePojo, @PathParam("username") String username, @PathParam("pet_id") Integer pet_id) {

        Optional<PetCase> persistedPetCase = new PetCaseService().savePetCase(petCasePojo, pet_id);

        if (persistedPetCase.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedPetCase.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }
    }
}
