/**
 * Package connecting co.edu.unbosque with resources
 */
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
/**
 * The resource package allows us to save, create, modify and list through the rest services
 */
/**
 * allows you to define complex expressions, thus converting certain sections of the URL into parameters that can be
 * used by the methods to know how to process the request.
 */
@Path("/vets/{username}/pet/{pet_id}/visits")
/**
 * The class is initialized VisitResource
 */
public class VisitResource {
    /**
     * This can be very useful for us to communicate with a web service.
     * @param visit visit!=null, visit!=" "
     * @param username username!=null, username!=" "
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
     * This method allows us to create an visit in the database
     */
    /**
     * The @PathParam annotation is a type of parameter that you can extract for use in your resource class. URI path
     * parameters are extracted from the request URI, and the parameter names correspond to the URI path template
     * variable names specified in the @Path class-level annotation.
     */
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
