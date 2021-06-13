/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VetPojo;
import co.edu.unbosque.Hatchiko.services.PetService;
import co.edu.unbosque.Hatchiko.services.VetService;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
@Path("/owners/{username}/pets/{pet_id}")
/**
 * The class is initialized PetUploadResource
 */
public class PetUploadResource {
    /**
     * The @PUT annotation is a request method designator and corresponds to the similarly named HTTP method.
     * @param userName userName!=null, userName!=" "
     * @param pet_id pet_id!=null, pet_id!=" "
     * @param petPojo petPojo!=null, petPojo!=" "
     * @return
     */
    @PUT
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows modifying the list of pets of the database
     */
    /**
     * The @PathParam annotation is a type of parameter that you can extract for use in your resource class. URI path
     * parameters are extracted from the request URI, and the parameter names correspond to the URI path template
     * variable names specified in the @Path class-level annotation.
     */
    public Response modify(@PathParam("username") String userName,@PathParam("pet_id") int pet_id, PetPojo petPojo) {
        Optional<Pet> persitedPet = new PetService().modifyPet(pet_id, petPojo);


        return Response.ok()
                .entity(persitedPet.get())
                .build();
    }
}
