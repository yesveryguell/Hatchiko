/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.filters.Logged;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VetPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.UserAppService;
import co.edu.unbosque.Hatchiko.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
/**
 * The resource package allows us to save, create, modify and list through the rest services
 */
/**
 * allows you to define complex expressions, thus converting certain sections of the URL into parameters that can be
 * used by the methods to know how to process the request.
 */
@Path("/vets")
/**
 * The class is initialized VetResource
 */
public class VetResource {
    /**
     * This can be very useful for us to communicate with a web service.
     * @param vetPojo vetPojo!=null, vetPojo!=" "
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
     * This method allows us to create an vet in the database
     */
    public Response create(VetPojo vetPojo) {

        Optional<VetPojo> persistedVet = new VetService().saveVet(vetPojo);

        if (persistedVet.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedVet.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Vet user could not be created")
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
     * This method allows the authentication of the vet's entry
     */
    /**
     * Binds the value(s) of a HTTP header to a resource method parameter, resource class field, or resource class bean property.
     */
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"Vet".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
    /**
     * The @GET annotation is a request method designator and corresponds to the similarly named HTTP method
     */
    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows to list all the veterinarians
     */
    public Response list(){

        List<VetPojo> vets = new VetService().listVet();

        return Response.ok()
                .entity(vets)
                .build();
    }
}
