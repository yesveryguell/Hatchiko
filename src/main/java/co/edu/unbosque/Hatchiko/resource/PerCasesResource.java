package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.pojos.PetCasePojo;
import co.edu.unbosque.Hatchiko.services.PetCaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pets/{pet_id}/petCases")

public class PerCasesResource {

    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows us to create an Pet case in the database
     */
    /**
     * The @PathParam annotation is a type of parameter that you can extract for use in your resource class. URI path
     * parameters are extracted from the request URI, and the parameter names correspond to the URI path template
     * variable names specified in the @Path class-level annotation.
     */
    public Response listCases(@PathParam("pet_id") Integer pet_id, @QueryParam("date1") String date1, @QueryParam("date2") String date2) {

            List<PetCasePojo> cases = new PetCaseService().listCases(pet_id, date1, date2);
            return Response.ok()
                    .entity(cases)
                    .build();

    }
}
