/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.PetService;

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
@Path("/owners/{username}/pets")
/**
 * The class is initialized PetsResource
 */
public class PetsResource {
    /**
     * This can be very useful for us to communicate with a web service.
     * @param pet pet!=null, pet!=" "
     * @param username username!=null, username!=" "
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
     * This method allows us to create an pet in the database
     */
    /**
     * The @PathParam annotation is a type of parameter that you can extract for use in your resource class. URI path
     * parameters are extracted from the request URI, and the parameter names correspond to the URI path template
     * variable names specified in the @Path class-level annotation.
     */
    public Response create(PetPojo pet, @PathParam("username") String username) {

        Optional<Pet> persistedPet = new PetService().savePet(pet, username);

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
