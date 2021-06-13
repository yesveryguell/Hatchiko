/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.filters.Logged;
import co.edu.unbosque.Hatchiko.resource.pojos.OfficialPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;
import co.edu.unbosque.Hatchiko.services.OfficialService;
import co.edu.unbosque.Hatchiko.services.UserAppService;

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
@Path("/officers")
/**
 * The class is initialized OfficialResource
 */
public class OfficialResource {
    /**
     * This can be very useful for us to communicate with a web service.
     * @param officialPojo officialPojo!=null, officialPojo!=" "
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
     * This method allows us to create an official in the database
     */
    public Response create(OfficialPojo officialPojo) {

        Optional<OfficialPojo> persistedOfficial = new OfficialService().saveOfficial(officialPojo);

        if (persistedOfficial.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOfficial.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Official user could not be created")
                    .build();
        }


    }
    /**
     * you can annotate any class with a record annotation to allow lombok to generate a record field.
     */
    @Logged
    /**
     * The @GET annotation is a request method designator and corresponds to the similarly named HTTP method
     */
    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.TEXT_PLAIN)
    /**
     * This method allows the authentication of the officer's entry
     */
    /**
     * Binds the value(s) of a HTTP header to a resource method parameter, resource class field, or resource class bean property.
     */
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"Official".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
}
