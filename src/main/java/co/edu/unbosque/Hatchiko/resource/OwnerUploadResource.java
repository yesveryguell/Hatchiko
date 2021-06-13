/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;
import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * The resource package allows us to save, create, modify and list through the rest services
 */
/**
 * allows you to define complex expressions, thus converting certain sections of the URL into parameters that can be
 * used by the methods to know how to process the request.
 */
@Path("/owners/{username}")
/**
 * The class is initialized OwnerUploadResource
 */
public class OwnerUploadResource {

    /**
     * The @PUT annotation is a request method designator and corresponds to the similarly named HTTP method.
     * @param userName userName!=null, userName!=" "
     * @param ownerPojo ownerPojo!=null, ownerPojo!=" "
     * @return
     */
    @PUT
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows modifying the list of owners of the database
     */
    /**
     * The @PathParam annotation is a type of parameter that you can extract for use in your resource class. URI path
     * parameters are extracted from the request URI, and the parameter names correspond to the URI path template
     * variable names specified in the @Path class-level annotation.
     */
    public Response modify(@PathParam("username") String userName, OwnerPojo ownerPojo) {
        Optional<Owner> persistedOwner = new OwnerService().modifyOwner(userName,ownerPojo);


        return Response.ok()
                .entity(persistedOwner.get())
                .build();
    }

}
