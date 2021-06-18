package co.edu.unbosque.Hatchiko.resource;

import co.edu.unbosque.Hatchiko.resource.pojos.CaseTotalPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.PetCasePojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitTotalPojo;
import co.edu.unbosque.Hatchiko.services.PetCaseService;
import co.edu.unbosque.Hatchiko.services.VisitService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("/visits")
public class VisitTotalResource {
    @GET
    /**
     * This annotation ensures that the content of the REST service is generated with different formats
     */
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * This method allows you to list all cases by type
     */
    public Response listVisit() {

        List<VisitPojo> visit = new VisitService().listVisit();
        List<VisitTotalPojo> totalVisits = new ArrayList<>();

        String[] types = {"esterilization", "implementacion-microchip", "vacunacion", "desparasitacion", "urgencia", "control"};

        for (int i = 0; i < types.length; i++) {
            List<VisitPojo> visitPojo = new ArrayList<VisitPojo>();
            for (int j = 0; j < visit.size(); j++) {
                if (types[i].equals(visit.get(j).getType())) {
                    visitPojo.add(visit.get(j));
                }
            }

            totalVisits.add(new VisitTotalPojo("Total casos por tipo " + types[i] + " es de " + (visitPojo.size()) + ":", visitPojo));
        }


        return Response.ok()
                .entity(totalVisits)
                .build();
    }
}

