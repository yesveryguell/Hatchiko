package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitPojo;
import co.edu.unbosque.Hatchiko.services.PetService;
import co.edu.unbosque.Hatchiko.services.VisitService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vets/{username}/visits")
public class VisitsResource {

    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the pets by race
     */
    public Response listVisits(@PathParam("username") String username) {

        List<VisitPojo> visits = new VisitService().listVisitVet(username);

        return Response.ok()
                .entity(visits)
                .build();
    }
}
