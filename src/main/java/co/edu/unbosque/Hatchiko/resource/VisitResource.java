package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;
import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitPojo;
import co.edu.unbosque.Hatchiko.services.PetService;
import co.edu.unbosque.Hatchiko.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vets/{username}/pet/{pet_id}/visits")
public class VisitResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VisitPojo visit, @PathParam("username") String username, @PathParam("pet_id") Integer pet_id) {

        Optional<Visit> persistedVisit = new VisitService().saveVisit(visit, username, pet_id);

        if (persistedVisit.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVisit.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }
    }
}
