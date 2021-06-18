package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;
import co.edu.unbosque.Hatchiko.resource.pojos.PetCasePojo;
import co.edu.unbosque.Hatchiko.services.PetCaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/pets/{pet_id}/petCases")

public class PetCasesResource {

    /**
     * This can be very useful for us to communicate with a web service.
     * @param petCasePojo petCasePojo!=null, petCasePojo!=" "
     * @param pet_id pet_id!=null, pet_id!=" "
     * @return
     */
    @POST
    /**
     * Annotation is used to specify what types of MIME media renderings a client resource can accept or consume.
     */
    @Consumes(MediaType.APPLICATION_JSON)
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
    public Response create(PetCasePojo petCasePojo, @PathParam("pet_id") Integer pet_id) {

        Optional<PetCase> persistedPetCase = new PetCaseService().savePetCase(petCasePojo, pet_id);

        if (persistedPetCase.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(petCasePojo)
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }
    }


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
