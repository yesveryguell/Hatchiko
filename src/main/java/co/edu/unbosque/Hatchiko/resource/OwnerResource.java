/**
 * Package connecting co.edu.unbosque with resources
 */
package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.resource.filters.Logged;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerTotalPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.UserAppService;

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
@Path("/owners")
/**
 * The class is initialized OwnerResource
 */
public class OwnerResource {
    /**
     * This can be very useful for us to communicate with a web service.
     * @param ownerPojo ownerPojo!=null, ownerPojo!=" "
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
     * This method allows us to create an owner in the database
     */
    public Response create(OwnerPojo ownerPojo) {

        Optional<OwnerPojo> persistedOwner = new OwnerService().saveOwner(ownerPojo);

        if (persistedOwner.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedOwner.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
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
     * This method allows the authentication of the entry
     */
    /**
     * Binds the value(s) of a HTTP header to a resource method parameter, resource class field, or resource class bean property.
     */
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"Owner".equals(role))
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
     * This method allows you to list all the owners
     */
    public Response list(){

        List<OwnerPojo> owners = new OwnerService().listOwner();
        List<OwnerTotalPojo> totalOwners = new ArrayList<>();

        String[] neighborhood = {"Antonio Nariño", "Barrios Unidos", "Bosa", "Chapinero", "Ciudad Bolivar", "Engativá", "Fontibón", "Kennedy", "La Candelaria", "Los Martires", "Puente Aranda", "Rafael Uribe Uribe", "San Cristóbal", "Santa Fe", "Suba", "Sumapaz", "Teusaquillo", "Tunjuelito", "Usaquen", "Usme"};

        for (int i = 0; i < neighborhood.length; i++) {
            List<OwnerPojo> owners1 = new ArrayList<OwnerPojo>();
            for (int j = 0; j < owners.size(); j++) {
                if (neighborhood[i].equals(owners.get(j).getNeighborhood())){
                    owners1.add(owners.get(j));
                }
            }

            totalOwners.add(new OwnerTotalPojo("Total dueños por la localidad de " + neighborhood[i] + " es de " +(owners1.size()) + ":", owners1));
        }


        return Response.ok()
                .entity(totalOwners)
                .build();
    }
}
