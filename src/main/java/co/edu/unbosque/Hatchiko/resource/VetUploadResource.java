package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VetPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/vets/{username}")
public class VetUploadResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String userName, VetPojo vetPojo) {
        Optional<Vet> persistedVet = new VetService().modifyVet(userName, vetPojo);


        return Response.ok()
                .entity(persistedVet.get())
                .build();
    }

    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all the owners
     */
    public Response listOwner(@PathParam("username") String username){

        List<VetPojo> vets = new VetService().listVet(username);

        return Response.ok()
                .entity(vets)
                .build();
    }
}

