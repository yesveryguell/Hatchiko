package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;
import co.edu.unbosque.Hatchiko.services.OwnerService;
import co.edu.unbosque.Hatchiko.services.UserAppService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("owners/login")
public class OwnerLoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginOwner(OwnerPojo user) {
        Optional<String> role = new UserAppService().validateUser(user.getUsername(), user.getPassword());
        List<String> roles = new ArrayList<>();
        roles.add(role.get());
        if (role != null) {
            if (role.get().equals("Owner")) {
                return Response.status(Response.Status.ACCEPTED)
                        .entity(roles).build();
            } else {
                return Response.serverError()
                        .entity("Invalid password")
                        .build();
            }
        } else {
            return Response.serverError()
                    .entity("Username was not founded")
                    .build();
        }
    }

}
